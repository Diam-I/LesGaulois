package personnages;

public class Romain {
	private String nom;
	private int force;
	
	private Equipement[] equipements;
	private int nbEquipement;
	public boolean vainqueur = true   ;

	public Romain(String nom, int force) {

		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
		this.nbEquipement = 0;
		assert this.force >= 0 : ("La force est positive");

	}

	public String getNom() {
		return nom;
	}
	
	public int getForce () {
		return force ; 
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}

	
	public String prendreParole() {

		return "Le romain " + nom + " : ";
	}


	public void sEquiper(Equipement equipement) {
		String soldat = "Le soldat " + nom;
		switch (nbEquipement) {
		case 2:
			System.out.println(soldat + " est déjà bien protégé !");
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println(soldat  + " possède déja un " + equipement + "!");
			} else {
				System.out.println(soldat + " s'équipe avec un " + equipement + "!");
				equipements[1] = equipement;
				nbEquipement++;
			}
			break;

		default:
			equipements[0] = equipement;
			nbEquipement++;
			System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
			break;

		}
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		
		Equipement[] equipementEjecte;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);

		force -= forceCoup;
		
		if (force > 0) {
			parler("Aïe");
			equipementEjecte=new Equipement[0];
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			
			//
			vainqueur = false ;
	
		}
		
		System.out.println(vainqueur);
		
		// post condition la force a diminuée
		
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if ((nbEquipement != 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup += resistanceEquipement;
		
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + "s'envole sous la force du coup.");
		
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);

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
