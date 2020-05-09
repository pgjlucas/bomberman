import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Bonus {
	private int posx ;
	private int posy ;
	int identifiantBonus ;
	
	long time ;
	String picture ;
	String p ;
	int a ;
	int b ;
	int c ;
	long d ;


	
	
	public Bonus() {
		this.posx = a ;
		this.posy = b ;
		this.time = d ;
		this.picture = "images/menu1.jpg" ;
		this.identifiantBonus = 0 ;
		
	}
	
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}
	
	public static int getPosxBloc(int posxBloc) {
		return posxBloc ;
	}
	public static int getPosyBloc(int posyBloc) {
		return posyBloc ;
	}
	
	
	public static boolean pourcentageApparitionBonus(){
		double pourcentageApparition = 0.2 ;
    	Random nbAleatoire = new Random();
    	int valeur= nbAleatoire.nextInt( (int)(1 /pourcentageApparition)+1);
    		if (valeur==1) {
    			return true ;
    		}
    		return false ;
    	}
	
	public static void apparitionBonus( boolean b, int x, int y, ArrayList<Bonus> listeBonus, int dureeflammes) {
		if (b ==  true){
			Bonus bonus = new Bonus() ;
			bonus.setPosx(x);
			bonus.setPosy(y);
			bonus.setTime(System.currentTimeMillis() + dureeflammes);
			listeBonus.add(bonus) ;
		}
		
	}
	
	public static void typeDeBonus(ArrayList<Bonus> listeBonus,String theme) {
		int nbBonus = 9 ;
		for(int i=0; i < listeBonus.size(); i++){
			if (listeBonus.get(i).identifiantBonus==0 ) {
				Random nbAleatoire = new Random();
				int valeur= nbAleatoire.nextInt(nbBonus +1) ;

				if (valeur ==1) {// Bonus de Vie
					listeBonus.get(i).picture ="images"+theme+"Bonus/bonus1.png";
					listeBonus.get(i).identifiantBonus = 1 ;
				}

				if (valeur ==2) { // Bonus de portee +1
					listeBonus.get(i).picture ="images"+theme+"Bonus/bonus2.png" ;
					listeBonus.get(i).identifiantBonus = 2 ;
				}
	
			
				if (valeur ==3) { // Bonus de portee 10
					listeBonus.get(i).picture ="images"+theme+"Bonus/bonus3.png";
					listeBonus.get(i).identifiantBonus = 3 ;
				}
				
				if (valeur ==4) { // Maluse portee -1
					listeBonus.get(i).picture ="images"+theme+"Bonus/bonus4.png";
					listeBonus.get(i).identifiantBonus = 4 ;
				}
					
				if (valeur ==5) { // Bonus bombes +2
					listeBonus.get(i).picture ="images"+theme+"Bonus/bonus5.png";
					listeBonus.get(i).identifiantBonus = 5 ;
				}
					
				
				if (valeur ==6) { // Malus bombes -1
					listeBonus.get(i).picture ="images"+theme+"Bonus/bonus6.png" ;
					listeBonus.get(i).identifiantBonus = 6 ;
				}
			
				if (valeur ==7) { // Bonus speed up
					listeBonus.get(i).picture ="images"+theme+"Bonus/bonus7.png";
					listeBonus.get(i).identifiantBonus = 7 ;
				}
				
				if (valeur ==8) { // Malus speed down
					listeBonus.get(i).picture ="images"+theme+"Bonus/bonus8.png";
					listeBonus.get(i).identifiantBonus = 8 ;
				}
				
				if (valeur ==9) { // Bonus bombes passent à travers
					listeBonus.get(i).picture ="images"+theme+"Bonus/bonus9.png";
					listeBonus.get(i).identifiantBonus = 9 ;
				}
		
			}
    	}
	}
    		
		
	
    public static void afficherBonus (ArrayList<Bonus> listeBonus) {
    	for(int i=0; i < listeBonus.size(); i++){
    		if (listeBonus.get(i).identifiantBonus!=0) {
    			StdDraw.picture(listeBonus.get(i).posx, listeBonus.get(i).posy, listeBonus.get(i).picture, 1 ,1) ;

    		}
    	}
    }
    
    
    public static void actionBonus( ArrayList<Bonus> listeBonus, Bomberman player){
    	for(int i=0; i < listeBonus.size(); i++){
    		if (listeBonus.get(i).posx == player.getPosx() && listeBonus.get(i).posy == player.getPosy()){
    			int a = listeBonus.get(i).identifiantBonus ;
    		
    			if  (a ==1) {// Bonus Vie
    				if (player.getVie()<6){
    				player.setVie(player.getVie() + 1) ;
    				}
    			}
    			
    			if (a == 2) {// Bonus portee +1
    				if (player.getRayon()<10) {
    				player.setRayon(player.getRayon() + 1) ;
    				} ;
    			}
    				
    			if (a == 3) { // Bonus portee 10
    				player.setRayon(10) ;
    			}
    			
    			if (a ==4) {// Malus portee -1
    				if (player.getRayon()>1) {
    				player.setRayon(player.getRayon() - 1) ;
    				}
    			}
    			
    			if (a == 5){ // Bonus bombes +2
    				if (player.getNbDeBombes() < 6) {
    				player.setNbDeBombes(player.getNbDeBombes() + 2) ;
    				}
    			}
    			
    			if (a == 6){ // Maluse bombes -2
    				if (player.getNbDeBombes() > 2) {
    				player.setNbDeBombes(player.getNbDeBombes() - 1) ;
    				}
    			}
    			
    			if (a == 7){ // Bonus speed up
    				if (player.getDistance() <= 0.5) {
    				player.setDistance( player.getDistance()*2.0) ;
    				System.out.println(player.getDistance()) ;
    				}
    			}
    			
    			if (a==8){ // Malus speed down
    				if (player.getDistance() >= 0.5){
    				player.setDistance( player.getDistance()/2.0) ;
    				}
    			}
    			
    			if (a==9){ // Bombe passe à traver
    				player.setBonusBombeRouge(true);
    				
    			}
    			
    			listeBonus.remove(i) ;
    		}
    		
    	
    	}
    	
    }

}
    

