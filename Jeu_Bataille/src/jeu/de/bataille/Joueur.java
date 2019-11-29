package jeu.de.bataille;

public abstract class Joueur
{
	private String nom;
	protected  Paquet paquet;
	
	
	public Joueur( String nom ) {
		this.nom = nom;
		this.paquet = new Paquet();		
	}
	
	public String getNom() {
		return this.nom;
	}
	public void nouveauJeu( ) {
		this.paquet.melanger();
	}
	
	
	
	public Carte jouer() {
				
		return paquet.retirerCarte( paquet.getNombreCartes());
	}
	
	
	
	public void recupererCarte( Carte c ) {
		
		 paquet.ajouterCarte(c);
	}
	
	public boolean aPerdu() {
		return this.paquet.getNombreCartes() == 0 ;
		
	}
	
	
	@Override
	public String toString() {
		String s = new String();
		s += this.nom + " voici la listes de vos cartes";
		s += '\n';
		s += this.paquet.toString();
		
		return s;
	}
	
	
	public abstract Carte choisirCarte( );
	
	
	
}