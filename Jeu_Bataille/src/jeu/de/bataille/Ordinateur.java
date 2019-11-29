package jeu.de.bataille;


import java.util.Random;

public class Ordinateur extends Joueur {

	private Random r;
	
	
	public Ordinateur( String nom ) {
		super( nom );
	}
	
	
	@Override
	public Carte choisirCarte()
	{
		this.r = new Random();
		int rand_val = r.nextInt(this.paquet.getNombreCartes());
	  
	  return this.paquet.retirerCarte(rand_val);
	  
	}
	
}
