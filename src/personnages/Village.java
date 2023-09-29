package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageoisMaximum ; 
	private Gaulois [] villageois ;
	private int nbVillageois = 0;
	
	
	public Village(String nom ,int nbViallgeoisMaximum ) {
		
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	private String ajouterHabitant ; 
	
	public void setChef (Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois ; 
		nbVillageois ++; 
	}
	
	public Gaulois trouverHabitant(int numVillageois) {
		return villageois[numVillageois];
	}
	
	public void afficherVillageois() {
	
		System.out.println("Dans village du chef " + chef + "vivent les légendaires gaulois : ");

		System.out.println();
		
		
	}
	
	public static void main(String[] args) {
		
		Village village = new Village("Village des Irréductibles",30);
		
		Chef abraracourcix = new Chef("Abraracourcix",6,village);
		
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix",8) ; 
		village.ajouterHabitant(asterix); 
	
		Gaulois gaulois = village.trouverHabitant(1);
		System.out.println(gaulois);

		}
		
	
}
