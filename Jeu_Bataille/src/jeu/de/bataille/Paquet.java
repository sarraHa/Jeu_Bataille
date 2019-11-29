package jeu.de.bataille;

import java.util.ArrayList; 
import java.util.Random;

public class Paquet
{
	 
	private ArrayList<Carte> cartes; 
	int getNombreCartes = 0;
	
	
	public Paquet() {
		this.cartes = new ArrayList<>(); 
	}
 
	 @Override
		public String toString()
		{
			String s = new String();
			
			for( int i = 0; i < this.cartes.size(); i++ )
			{
				
				s += i + " " + this.cartes.get(i).toString();
				s += "\n";
			}
			
			return s;
		} 
	 
	 
	public void ajouterCarte( Carte c ) {
		this.cartes.add( c );
	}
	
	
	public Carte retirerCarte( int indice ) {
		Carte c = this.cartes.get( indice );
		this.cartes.remove( indice );
		return c;
	}
	
	
	public Carte retirerCarte( Carte c ) {	
		this.cartes.remove( c );
		return c; 
	}
	
	public Carte getCarte( int indice ) {
		return this.cartes.get( indice );
	}
	
	public int getNombreCartes() {
		return this.cartes.size();
	}
	
	
	public void melanger()
	{
		Random r = new Random();
		int r1;
		int r2;
		

		
		for( int i = 0; i < getNombreCartes()*2; i++) {
			
			r1 = r.nextInt( getNombreCartes() );
			r2 = r.nextInt( getNombreCartes() );
			
			Carte temp = this.cartes.get( r1 );
			
			this.cartes.set( r1 ,  this.cartes.get( r2 ));
			this.cartes.set( r2 ,  temp);
			
		}
	}
	
	
	
}