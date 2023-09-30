package personnages;

public class Romain {
	private String nom;
	private int force; 
	private int forceInitiale; 

	
	
	public  Romain(String nom, int force) {
		
		this.nom= nom; 
		this.force= force;
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

	public static void main(String[] args) {
		Romain minus= new Romain("Minus",6); 
		
		String paroleMinus = minus.prendreParole();
		System.out.println(paroleMinus);
		minus.parler("Bonjour c'est Minus ! ");
		minus.recevoirCoup(10);
	}
}
