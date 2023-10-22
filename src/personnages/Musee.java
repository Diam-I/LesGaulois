package personnages;

public class Musee {
	private Trophee [] trophees;
	int nbTrophee ;
	int tropheeMax = 200 ;
	
	public Musee() {
		trophees = new Trophee[tropheeMax];
		nbTrophee = 0;
	}
	
	public void donnerTrophee(Trophee trophee) {
		trophees [nbTrophee] = trophee;
		nbTrophee ++ ;
		
	}

	public String extraireInstructionsOCaml() {
		String texte ;
		texte = "let musee = [ " ;
		for(int i=0;i<nbTrophee;i++) {
			texte+=trophees[i].donnerNom()+", "+trophees[i].getEquipement()+";";
		}
		texte+= "]";
		
		return texte ;
		
	}
	
	
}
