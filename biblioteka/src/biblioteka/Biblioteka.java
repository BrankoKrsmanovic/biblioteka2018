package biblioteka;

import java.util.LinkedList;

import biblioteka.interfejs.BibliotekaInterfejs;

public class Biblioteka implements BibliotekaInterfejs {

	private LinkedList<Knjiga> knjige = new LinkedList<Knjiga>();
	
	@Override
	public void dodjaKnjigu(Knjiga k) {
		if(k == null || knjige.contains(k))
			throw new RuntimeException("Knjiga je NULL ili vec postoji");
		knjige.add(k);
	}

	@Override
	public void obrisiKnjigu(Knjiga k) {
		if(k == null || !knjige.contains(k))
			throw new RuntimeException("Knjiga je NULL ili ne postoji");
		knjige.remove(k);
	}

	@Override
	public LinkedList<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public LinkedList<Knjiga> pronadjiknjigu(Autor autor, String isbn, String naslov, String izdavac) {
		
		if(naslov == null) {
			throw new RuntimeException("Morate uneti naslov!");
		}
		
		LinkedList<Knjiga> novaLista = new LinkedList<Knjiga>();
		
		for (int i = 0; i < knjige.size(); i++) {
			if(knjige.get(i).getNaslov().contains(naslov))
				novaLista.add(knjige.get(i));
		}
		return novaLista;
	}

}
