package jeu.de.bataille;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jeu
{
	
	private Paquet paquet ;
	public final int Nb_forme = 4;
	public final int Nb_Carteparforme = 13;

	
	private Ordinateur ordinateur1;
	private Ordinateur ordinateur2;
	private Humain humain;
	
	
	
	
	public Jeu()
	{
		
		this.paquet = new Paquet();
		this.ordinateur1 = new Ordinateur("Ordinateur1");
		this.ordinateur2 = new Ordinateur("Ordinateur2");
	}
	
	 private void creerNouveauPaquet() {
	 this.paquet = new Paquet();
	 int i,j;
		
	for( j = 0; j < Nb_forme ; j++) {
			
		for( i = 0 ;i < Nb_Carteparforme ; i++) {
			Carte c = new Carte(i+1, Couleur.values[j]);
			paquet.ajouterCarte(c);
			}	
		}		
	}
	
		
	private void distribuerPaquet1(){
						
	for( int i = 0; i < this.paquet.getNombreCartes(); i++ ){
			if( i % 2 == 0 ){
					
				this.ordinateur1.paquet.ajouterCarte( this.paquet.getCarte(i ) );
			}
			else
			{
				this.humain.paquet.ajouterCarte( this.paquet.getCarte(i) );

				}
			}
		}
		
		
	private void distribuerPaquet2(){
		
		for( int i = 0; i < this.paquet.getNombreCartes(); i++ ){
				if( i % 2 == 0 ){
						
					this.ordinateur1.paquet.ajouterCarte( this.paquet.getCarte(i ) );
				}
				else
				{
					this.ordinateur2.paquet.ajouterCarte( this.paquet.getCarte(i) );

					}
				}
			}
			
	
	
		private Joueur joueurCoup()
		{
			if( ordinateur1.getClass().equals("Humain") )
			{
				ordinateur1.choisirCarte();
				
				return humain;
			}
			else
			{
				humain.choisirCarte();
				
				return ordinateur1;
			}
		}
	
		private void jouerPartie1(String nom){
			
			this.humain = new Humain( nom );
			this.creerNouveauPaquet();
			this.paquet.melanger();
			this.distribuerPaquet1();
			int i = 0;
			
			while( true )
			{
				System.out.println("Ordinateur a : " + ordinateur1.paquet.getNombreCartes()+ " Cartes");
				System.out.println( humain.getNom() + " a : " + humain.paquet.getNombreCartes()+ " Cartes");
				
				System.out.println(".......");
				System.out.println(humain.toString());

				
				Carte o = ordinateur1.choisirCarte();
				Carte h = humain.choisirCarte();

				
				System.out.println( humain.getNom() + " a joué : "+ h.toString());

				System.out.println("Ordinateur a joué : " + o.toString());

				
				if( o.compare( h ) > 0 )
				{
					ordinateur1.recupererCarte(o);
					ordinateur1.recupererCarte(h);

				}
				else
				{
					humain.recupererCarte(h);
					humain.recupererCarte(o);
				}
								
				if( ordinateur1.aPerdu() )
				{
					System.out.println("Ordinateur a gagne apres "+ i +" tours");
					System.exit(0);
				}
				if( humain.aPerdu())
				{
					System.out.println( humain.getNom() + " a gagne apres "+ i +" tours");

					System.exit(0);
				}
			i++;
			}
						
		}
	
	
	
		private void jouerPartie2(){
			
			this.creerNouveauPaquet();
			this.paquet.melanger();
			this.distribuerPaquet2();
			int i = 0;
			while( true )
			{
				System.out.println("Ordinateur1 a : " + ordinateur1.paquet.getNombreCartes()+ " Cartes");
				System.out.println("Ordinateur2 a : " + ordinateur2.paquet.getNombreCartes()+ " Cartes");
				System.out.println(".........");
				

				Carte o1 = ordinateur1.choisirCarte();
				Carte o2 = ordinateur2.choisirCarte();

				System.out.println("Ordinateur1 a joué : " + o1.toString());
				System.out.println("Ordinateur2 a joué : "+ o2.toString());


				
				if( o1.compare( o2 ) > 0 )
				{
					ordinateur1.recupererCarte(o1);
					ordinateur1.recupererCarte(o2);
				}
				else
				{
					ordinateur2.recupererCarte(o1);
					ordinateur2.recupererCarte(o2);
				}
								
				if( ordinateur1.aPerdu() )
				
				{
					System.out.println("Ordinateur1 a gagné après "+ i +" tours");
					System.exit(0);
				}
				if( ordinateur2.aPerdu())
				{
					System.out.println("Ordinateur2 a gagné après "+ i +" tours");

					System.exit(0);
				}
			i++;
			}
						
		}
	
	public static void main(String[] args)
	{
		
		System.out.println("BIEN VENUE DANS LE JEU DE LA BATAILLE ");
		System.out.println("............................");

		System.out.println("ENTREZ : 1 si vous voulez jouer avec un Ordinateur");
		System.out.println("ENTREZ : 2 si vous voulez faire jouer 2 Ordinateurs");

		Jeu jeu = new Jeu();

		BufferedReader br = null;
		int indice;
		String nom;
		try
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			indice = Integer.parseInt( br.readLine() );

			if( indice == 1 ) {
				
				System.out.print("Entrez votre nom : ");
				nom = br.readLine(); 

				jeu.jouerPartie1( nom );
			}
			else if ( indice == 2 ) {
				
				jeu.jouerPartie2();
			}
			else {
				
				throw new IllegalArgumentException("Valeur entée non valide");
			}
		}
		catch( Exception e )
		{
			System.err.println("Erreur : " + e.getMessage());
		}
		
		


	}
	
	
	
	
	
	
	
	
	
	
	
}