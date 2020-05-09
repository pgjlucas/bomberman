import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;
import java.util.ArrayList;


public class Bombe {

	int posx ;
	int posy ;
	long time ;
	int dureeflammes ;
	int rayonb ;
	boolean bonusBombeRouge ;
	int a ;
	int b ;
	int c ;
	boolean d ;
	

	public Bombe(int k,int r, int x, int y) {
			this.posx = a ;
			this.posy = b ;
			this.time = System.currentTimeMillis() + 4500 ;
			this.dureeflammes = 500 ;
			this.rayonb = c ;
			this.bonusBombeRouge = d ;
	}
	
	
	public boolean isBonusBombeRouge() {
		return bonusBombeRouge;
	}


	public void setBonusBombeRouge(boolean bonusBombeRouge) {
		this.bonusBombeRouge = bonusBombeRouge;
	}


	public int getRayonb() {
		return rayonb;
	}


	public void setRayonb(int rayonb) {
		this.rayonb = rayonb;
	}


	public long getTime() {						 
		return time;
	}

	
	public void setTime(long time) {
		this.time = time ;
	}

	
	public double getPosxBombe(){
		return posx;
	}
	
	
	public void setPosxBombe(int posx) {
		this.posx = posx;
	}
	
	
	public double getPosyBombe(){
		return posy;
	}
	
	
	public void setPosyBombe(int posy) {
		this.posy = posy;
		}

	
	 public void afficherBombe(int [][] lab, String theme){
		 
		 		if (this.time -dureeflammes > System.currentTimeMillis() ){
		 			
		 			lab [16-this.posy][this.posx] = 3 ;
		 			StdDraw.picture(this.posx, this.posy, "images"+theme+"Bombes/bombe.png", 0.75, 0.75);
		 		}
		 		
		 		else if (this.time < System.currentTimeMillis()) {
		 			lab [16-this.posy][this.posx] = 1 ;	
		 		}
		 }
	 

	
	public Bomberman destruction(ArrayList<Bombe> liste, int [][] lab, Bomberman j1, Bomberman j2,  ArrayList<Bonus> listeBonus) {
		int r =1 ;
		int l =1 ;
		int u =1 ;
		int d =1 ;
		int dimy =16 ;
		int dimx =20 ;
	

				if ( this.time -dureeflammes <= System.currentTimeMillis() && this.time >= System.currentTimeMillis()){
					for(int i=1 ; i<= this.rayonb ; i++ ) {

					// Explosion Bombe //
					lab[dimy-this.posy ][this.posx]=4 ;
					
				/*	if (this.bonusBombeRouge==true ){
						r=i ;
						l=i ;
						u=i ;
						d=i ;
					}*/
					
					// Flammes à droite //
					if ( this.posx +r <= dimx && lab [dimy-this.posy][this.posx+r]==1 ) {
						lab[dimy-this.posy ][this.posx+r]=4 ;
						r += 1 ;	
					}
					if ( r <= this.rayonb && this.posx +r <= dimx && lab [dimy-this.posy][this.posx+r]==2) {
						lab [dimy-this.posy][this.posx+r]=4 ;
						int x = this.posx + r ;
						int y =this.posy  ;
						Bonus.apparitionBonus( Bonus.pourcentageApparitionBonus(), x,  y, listeBonus, dureeflammes) ; 	
					}
					// Flammes à gauche //
					if ( this.posx -l >=0 && lab [dimy-this.posy][this.posx-l]==1) {
						lab[dimy-this.posy ][this.posx-l]=4 ;
						l += 1 ;
					}
					if ( l<= this.rayonb && this.posx -l >=0 && lab [dimy-this.posy][this.posx-l]==2) {
						lab[dimy-this.posy ][this.posx-l]=4 ;
						int x = this.posx- l ;
						int y =this.posy  ;
						Bonus.apparitionBonus( Bonus.pourcentageApparitionBonus(), x,  y, listeBonus, dureeflammes) ; 
						
					}
					// Flammes en bas //
					if ( this.posy -u >=0 && lab [dimy-this.posy+u][this.posx]==1) {
						lab[dimy-this.posy+u ][this.posx]=4 ;
						u += 1 ;
					}
					if ( u<= this.rayonb && -this.posy + u <=0 && lab [dimy-this.posy+u][this.posx]==2) {
						lab[dimy-this.posy+u ][this.posx]=4 ;
						int x = this.posx ;
						int y =this.posy - u ;
						Bonus.apparitionBonus( Bonus.pourcentageApparitionBonus(), x,  y, listeBonus, dureeflammes) ; 
						
					}
					// Flammes en haut //
					if (this.posy +d <=dimy && lab [dimy-this.posy-d][this.posx]==1) {
						lab[dimy-this.posy-d ][this.posx]=4 ;
						d += 1 ;
					} 
					if (d<= this.rayonb  && dimy-this.posy-d >=0 && lab [dimy-this.posy-d][this.posx]==2) {
						lab[dimy-this.posy-d ][this.posx]=4 ;
						int x = this.posx ;
						int y =this.posy +d ;
						Bonus.apparitionBonus( Bonus.pourcentageApparitionBonus(), x,  y, listeBonus, dureeflammes) ; 
						
					}
					
					// Dommages collateraux (Exploser les bombes dans le rayon d'explosion) //
					for (int h=0 ; h<liste.size() ; h++ ){
						if(liste.get(h)!=this ) {
							if (i <= r && liste.get(h).getPosxBombe() == this.posx +i && liste.get(h).getPosyBombe() == this.posy && lab [dimy-(int)liste.get(h).getPosyBombe()][(int)liste.get(h).getPosxBombe()]==3|| 
								i <= l && liste.get(h).getPosxBombe() == this.posx -i && liste.get(h).getPosyBombe() == this.posy && lab [dimy-(int)liste.get(h).getPosyBombe()][(int)liste.get(h).getPosxBombe()]==3|| 
								i <= d && liste.get(h).getPosxBombe() == this.posx 	&& liste.get(h).getPosyBombe() == this.posy +i && lab [dimy-(int)liste.get(h).getPosyBombe()][(int)liste.get(h).getPosxBombe()]==3||
								i <= u && liste.get(h).getPosxBombe() == this.posx 	&& liste.get(h).getPosyBombe() == this.posy -i && lab [dimy-(int)liste.get(h).getPosyBombe()][(int)liste.get(h).getPosxBombe()]==3) {
								long a =dureeflammes +System.currentTimeMillis() ;
									(liste.get(h)).setTime(a);
							}
						}
					}
			
					}
				
					for(double i=0 ; i<= this.rayonb ; i=i+0.25 ) {
					// Tuer (Enlever les vies aux joueurs dans le rayon d'explosion) //
						if (i <= r && j1.posx == this.posx +i && j1.posy == this.posy || 
							i <= l && j1.posx == this.posx -i && j1.posy == this.posy || 
							i <= d && j1.posx == this.posx && j1.posy == this.posy +i ||
							i <= u && j1.posx == this.posx && j1.posy == this.posy -i ) {
								return j1 ;
								
						}
						if (i <= r && j2.posx == this.posx +i && j2.posy == this.posy || 
							i <= l && j2.posx == this.posx -i && j2.posy == this.posy ||
							i <= d && j2.posx == this.posx && j2.posy == this.posy +i ||
							i <= u && j2.posx == this.posx && j2.posy == this.posy -i ) {
									return j2 ;
						}
					}	
				}
		return null ;
	}

				
	public void reconstruction(ArrayList<Bombe> liste1,ArrayList<Bombe> liste2, int [][] lab) {
		int dimy =16 ;
		int dimx =20 ;
		int tempsDeReconstruction = 300 ;
		
			for(int i=1 ; i<= this.rayonb ; i++ ) {		
				if (this.time  < System.currentTimeMillis() && this.time + tempsDeReconstruction > System.currentTimeMillis()  ) {
				
					// Disparition des flammes à droite //
					if ( this.posx+i <= dimx && lab [dimy-this.posy][this.posx+i]==4 ) {
						lab[dimy-this.posy ][this.posx+i]= 1 ;
					}
					// Disparition des flammes à gauche //
					if ( this.posx-i >=0 && lab [dimy-this.posy][this.posx-i]==4 ) {
						lab[dimy-this.posy ][this.posx-i]=1 ;
					}
					// Disparition des flammes en bas //
					if ( this.posy -i >=0 && lab [dimy-this.posy+i][this.posx]==4 ) {
						lab[dimy-this.posy+i ][this.posx]=1 ;
					}
					// Disparition des flammes en haut //
					if ( this.posy +i <=dimy &&  lab [dimy-this.posy-i][this.posx]==4 ) {
						lab[dimy-this.posy-i ][this.posx]=1 ;
					}		
				}
			}

			// Supression bombe liste //
			for (int i=0; i<liste1.size(); i++){
				if ( liste1.get(i).time + tempsDeReconstruction < System.currentTimeMillis()) {
						liste1.remove(this) ;
				}
			}
			for (int i=0; i<liste2.size(); i++){
				if ( liste2.get(i).time + tempsDeReconstruction < System.currentTimeMillis()) {
						liste2.remove(this) ;
				}
			}		
	}
	
	public static long premiereBombeExplose (ArrayList<Bombe> liste) {
				if (liste.size()> 0)  {
					return liste.get(0).getTime() ;
				}
	
		return 0 ;
		
	}
	
	// à supprimer
	
	public int compteurIndiceVie (int k) {
		int c =0 ;
	
		if ( k ==1) {
			c +=1 ;
		}
		if (c> 0 && this.time -300 > System.currentTimeMillis() ) {
			return 1 ;
		}
		return 0 ;
	}
		
	
}
