
	import java.awt.Color;
import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.List;

//import com.sun.glass.events.KeyEvent;


	import edu.princeton.cs.introcs.StdDraw;

	public class Bomberman {
		 double posx;
		 double posy;
		 int up ;
		 int down;
		 String avatarJoueur ;
		 int left;
		 int right;
		 int vie ;
		 int rayon ;
		 int nbDeBombes ;
		 boolean bonusBombeRouge ;
		 
		 
		 public boolean isBonusBombeRouge() {
			return bonusBombeRouge;
		}

		public void setBonusBombeRouge(boolean bonusBombeRouge) {
			this.bonusBombeRouge = bonusBombeRouge;
		}

		double distance ;
		 int idJoueur ;
		 Color color;
		 
		 public double getDistance() {
			return distance;
		}

		public void setDistance(double distance) {
			this.distance = distance;
		}
		
		 public int getRayon() {
			 	return rayon;
		 }

		 public void setRayon(int rayon) {
			 	this.rayon = rayon;
		 }

		 public int getVie() {
				return vie;
		 }

		 public void setVie(int vie) {
				this.vie = vie;
		 }
		 
		 public double getPosx() {
			 	return posx;
		 }

		 public void setPosx(double posx) {
			 	this.posx = posx;
		 }
		
		 public double getPosy() {
			 	return posy;
		 }

		public void setPosy(double posy) {
				this.posy = posy;
		}

		public int getNbDeBombes() {
				return nbDeBombes;
		}

		public void setNbDeBombes(int nbDeBombes) {
				this.nbDeBombes = nbDeBombes;
		}

		public Bomberman(int nombre, int choixJoueur){
			 this.vie = 3 ;
			 this.rayon = 3 ;
			 this.nbDeBombes = 3 ;
			 this.distance = 0.25 ;
			 
			
			 
			 if (nombre == 1) {
				 this.idJoueur = 1 ;
				 this.posx=1;
				 this.posy=1;
				 this.up = 90;
				 this.down = 83;
				 this.left=81 ;
				 this.right = 68;
				 this.bonusBombeRouge = false ;
				 this.avatarJoueur = "j1" ;
				 
			 }
			 else {
				 this.idJoueur = 2 ;
				 this.posx= 19;
				 this.posy= 15;
				 this.up = 38;
				 this.down = 40;
				 this.left=37 ;
				 this.right = 39; 
				 this.bonusBombeRouge = false ;
				 this.avatarJoueur = "j2" ;
				 
			 } 
		}

		public void drawPlayer(String theme){
			
			if( StdDraw.isKeyPressed(down)) {
				StdDraw.picture(this.posx, this.posy, "images"+theme+"Personnages/"+avatarJoueur+"Face.png", 1, 1);
			}
			if( StdDraw.isKeyPressed(right)) {
				StdDraw.picture(this.posx, this.posy, "images"+theme+"Personnages/"+avatarJoueur+"Droite.png", 1, 1);
			}
			if( StdDraw.isKeyPressed(left)) {
				StdDraw.picture(this.posx, this.posy, "images"+theme+"Personnages/"+avatarJoueur+"Gauche.png", 1, 1);
			}
			if( StdDraw.isKeyPressed(up)) {
				StdDraw.picture(this.posx, this.posy, "images"+theme+"Personnages/"+avatarJoueur+"Dos.png", 1, 1);
			}
			if (StdDraw.isKeyPressed(down)== false && StdDraw.isKeyPressed(up)== false && 
					StdDraw.isKeyPressed(left)== false && StdDraw.isKeyPressed(right)== false ){
				
				StdDraw.picture(this.posx, this.posy, "images"+theme+"Personnages/"+avatarJoueur+"Face.png", 1, 1);
			}
		 }
		

		public void deplacement(Terrain ter){

			double l = 1 ;
			double d = 0 ;
			double r = 1 ;
			double u =-1 ;
			double p = 0 ;
			
			if (this.distance==1) {
			l = 1 ;
			d = 0 ;
			r = 1 ;
			u = -1 ;	
			p = 0 ;
			}
			if (this.distance==0.25) {
			l = 0.25 ;
			d = 0.75 ;
			r = 1 ;
			u = -1 ;	
			p = 0.75 ;
			}
			if (this.distance==0.5) {
			l = 0.5 ;
			d = 0.5 ;
			r = 1 ;
			u = -1 ;
			p = 0.5 ;
			}
			
			 if( StdDraw.isKeyPressed(up) && ter.getlab()[16-(int)(this.posy-u) ][(int)(this.posx+p)]==1 
					 && ter.getlab()[16-(int)(this.posy-u) ][(int)(this.posx)]==1 ){
				 this.posy +=this.distance ;
			 }
			 if( StdDraw.isKeyPressed(down) && ter.getlab()[17-(int)(this.posy+d)][(int)(this.posx+p)]==1
					 && ter.getlab()[17-(int)(this.posy+d) ][(int)(this.posx)]==1 ){
				 this.posy -=this.distance ;
			 }
			 if( StdDraw.isKeyPressed(left) && ter.getlab()[16-(int)(this.posy+p)][(int)(this.posx-l)]==1 
					 && ter.getlab()[16-(int)(this.posy)][(int)(this.posx-l)]==1){ 
				 this.posx -=this.distance ;
			 }
			 if( StdDraw.isKeyPressed(right) && ter.getlab()[16-(int)(this.posy+p)][(int)(this.posx+r)]==1
					 && ter.getlab()[16-(int)(this.posy)][(int)(this.posx+r)]==1){
				 this.posx +=this.distance ;
			 } 
		}
		

		public static void timeclick (ArrayList<Bombe> liste) {
			for (int i=0 ; i< liste.size(); i++) {
				for (int j=i+1 ;j<liste.size(); j++) {
					if (liste.get(i)!= null && liste.get(j) != null) {
						if ((liste.get(j)).posx == (liste.get(i)).posx &&
								(liste.get(j)).posy == (liste.get(i)).posy ) {
								liste.remove(j);
						}
					}
				}
			}
		}
		
		
		public Bombe poserBombe(int touch, ArrayList<Bombe> liste, int [][] lab) {
			Bombe g = new Bombe(0, 0 , 0, 0) ;
			int dimy = 16 ;
			int pjx,pjy; 
			if ( StdDraw.isKeyPressed(touch) && liste.size() < nbDeBombes 
					&& lab [dimy-(int)this.posy][(int)this.posx]!= 3
					&& this.posx==(int)this.posx && this.posy==(int)this.posy)  {
					pjx = (int)this.posx ;
					pjy = (int)this.posy ;
					g.setBonusBombeRouge(this.bonusBombeRouge);
					g.setRayonb(this.rayon);
					g.setPosxBombe(pjx);
					g.setPosyBombe(pjy);
					return g ;
			}
			return  null ;
		}
	
		public boolean gameOver () {
			if (this.vie<=0) {
				 return true ;
				
			}
			return false ;
		}
		
		public static void perteVie (Bomberman player) {
			
			if (player!=null){
				if ( player.idJoueur ==1) {
					player.vie = player.vie -1 ;
					player.posx =1 ;
					player.posy =1 ;
				}
	
				if ( player.idJoueur==2) {
					player.vie = player.vie -1 ;
					player.posx =19 ;
					player.posy =15 ;
				}
			}
		}
	
}