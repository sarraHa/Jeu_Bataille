package jeu.de.bataille;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Humain extends Joueur
{
	public Humain(String nom)
	{
		super(nom);
	}
	
	@Override
	public Carte choisirCarte()
	{
		
		int indice ;
		BufferedReader br = null;
		System.out.println("Choisissiez une carte");
		
		try
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			
			indice = Integer.parseInt( br.readLine() );
			
			while( indice < 0 || indice >= this.paquet.getNombreCartes() ) {
				
				System.err.println("Erreur : indice n'est pas dans l'intervale");
				System.err.println("Essayez encore une fois");

				indice = Integer.parseInt( br.readLine() );				
				
			}
			
			return this.paquet.retirerCarte( indice );
		}
		catch( Exception e )
		{
			System.err.println("Erreur : " + e.getMessage());
		}
		
		return null;
	}
}