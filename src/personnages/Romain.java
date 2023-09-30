package personnages;

public class Romain {
	private String nom;
	private int force; 
	private int forceInitiale; 
	private Equipement [] equipements ;
	private int nbEquipement ;

	
	
	public  Romain(String nom, int force) {
		
		this.nom= nom; 
		this.force= force;
		this.equipements = new Equipement[2];
		this.nbEquipement = 0 ;
		assert this.force >=0 :("La force est positive");

	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>"); 
	}
	
	public String prendreParole() {
		
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert forceCoup>=0 : "La force d'un Romain est positive"; 
		forceInitiale = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		}else {
			parler("J'abandonne ...");
		}
		assert forceInitiale > force : "La force d'un Romain a diminué";
	}
	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
			case 2 : 
				System.out.println("Le soldat "+ nom+ " est déjà bien protégé !");
				break;
			case 1 : 
				if (equipements[0]==equipement) {
					System.out.println("Le soldat " + nom + " possède déja un " + equipement + "!");
				}
				else {
					System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + "!");				
					equipements[1]=equipement;
					nbEquipement ++;
				}
				break;
			
			default: 
				equipements[0] = equipement; 
				nbEquipement ++;
				System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
				break;
				
		}
	}

	public static void main(String[] args) {
		Romain minus= new Romain("Minus",6); 
		
		String paroleMinus = minus.prendreParole();
		System.out.println(paroleMinus);
		minus.parler("Bonjour c'est Minus ! ");
		minus.recevoirCoup(10);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

		
		
//		System.out.println("L'équipement :" + Equipement.CASQUE);
//		System.out.println("L'équipement :"+ Equipement.BOUCLIER);
		
	}
}
