package jeu.de.bataille;

public class Carte {
	private int valeur;
	private Couleur couleur; 
	
	public Carte(int v, Couleur c)
	{
		this.valeur = v;
		this.couleur = c;
	}
	
	int getValeur()
	{
		return this.valeur;
	}
	
	Couleur getCouleur()
	{
		return this.couleur;
	}
	
	@Override
	public String toString()
	{
		return this.valeur + " " + this.couleur;
	}
	
	
	public int compare( Carte c) {
		
		int v = Integer.compare( this.valeur , c.valeur ); 
		if( v != 0) 
			return v;
		else 
			v = Integer.compare( this.couleur.ordinal() , c.couleur.ordinal() ); 
			return v;
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
}