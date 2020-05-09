import edu.princeton.cs.introcs.StdDraw;

import java.util.ArrayList;

import javax.sound.sampled.Clip;

import java.awt.event.KeyEvent;
import java.io.File;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


Terrain ter = new Terrain();
Bomberman j1 = new Bomberman(1,1);
Bomberman j2 = new Bomberman(2,1);
ArrayList<Bombe> Bombesj1 = new ArrayList<Bombe>();
ArrayList<Bombe> Bombesj2 = new ArrayList<Bombe>();
ArrayList<Bombe> Bombesj = new ArrayList<Bombe>();
ArrayList<Bonus> ListeBonus = new ArrayList<Bonus>() ;
File debut = new File ("sons/Menu/debut.wav") ;
File fin = new File ("sons/Menu/fin.wav") ;
ArrayList listeSon = new ArrayList<File>() ;
Son sonDebut = new Son(debut);
Son sonFin = new Son(fin);





int dim =40 ;
StdDraw.setCanvasSize(33*dim,19*dim);

boolean A = true;
boolean B = true;
boolean C = true;
boolean D = true;

String theme = "theme" ;

if (A==true  ){
	sonDebut.jouerSon() ;
}
while(A==true){
	Menu.menuChoixTheme("images/Menu/theme1.jpg", "images/Menu/theme2.jpg") ;
	if (Menu.theme()!="no"){
		theme= Menu.theme() ;
		A=false ;
		B=true ;
		
	}
}

File menu = new File ("sons"+theme+"menu.wav");
File jeu = new File ("sons"+theme+"jeu.wav");
Son sonMenu = new Son(menu);
Son sonJeu= new Son(jeu);

if (B==true ) {
	sonDebut.stopSon() ;
	sonMenu.jouerSon();
}

while(B==true){
	Menu.afficherMenuDebutDeJeu("images"+theme+"Menu/debut.jpg") ;
	
	
	if(StdDraw.isKeyPressed(KeyEvent.VK_ENTER)==true){
		B=false;
		C=true ;
	}
}

if ( C==true) {
	sonMenu.stopSon();
	sonJeu.jouerSon();
}
while(C==true){
	StdDraw.clear();
	
	Menu.afficherMenuMilieuDeJeu("images"+theme+"Menu/fond.jpg") ;
	Menu.afficherRayonExplosion( j1,"images"+theme+"Menu/rayon.png") ;
	Menu.afficherRayonExplosion( j2,"images"+theme+"Menu/rayon.png") ;
	Menu.afficherVie( 1, j1.getVie(),"images"+theme+"Menu/vie.png") ;
	Menu.afficherVie( 2, j2.getVie(),"images"+theme+"Menu/vie.png") ;
	Menu.afficherBombes(j1, Bombesj1,"images"+theme+"Menu/bombe.png");
	Menu.afficherBombes(j2, Bombesj2,"images"+theme+"Menu/bombe.png");
	Menu.afficherVitesse( j1,"images"+theme+"Menu/vitesse.png") ;
	Menu.afficherVitesse( j2,"images"+theme+"Menu/vitesse.png") ;
	Menu.afficherAvatar( j1,theme) ;
	Menu.afficherAvatar( j2,theme) ;
	Menu.afficherBonusBombeRouge( j1,"images"+theme+"Menu/bonusSpe.png") ;
	Menu.afficherBonusBombeRouge( j2,"images"+theme+"Menu/bonusSpe.png") ;
	Terrain.afficherTerrain(ter.getlab(), Bombe.premiereBombeExplose(Bombesj),theme);
	j2.drawPlayer(theme);
	j2.deplacement(ter);
	j1.drawPlayer(theme);
	j1.deplacement(ter);
	
	if ( j1.poserBombe(32, Bombesj1, ter.getlab()) != null){
	Bombesj1.add(j1.poserBombe(32, Bombesj1, ter.getlab())) ;
	}
	Bomberman.timeclick (Bombesj1) ;
	if (j2.poserBombe(KeyEvent.VK_ENTER, Bombesj2, ter.getlab()) != null ){
	Bombesj2.add(j2.poserBombe(KeyEvent.VK_ENTER, Bombesj2, ter.getlab())) ;
	}
	Bomberman.timeclick (Bombesj2) ;
	
	for (int i=0; i< Bombesj1.size() ; i++) { 
	Bombesj.add(Bombesj1.get(i)) ;
	}
	for (int i=0; i< Bombesj2.size() ; i++) { 
	Bombesj.add(Bombesj2.get(i)) ;
	}
	Bomberman.timeclick (Bombesj) ;

	for (int i=0; i< Bombesj.size() ; i++) {
		
			(Bombesj.get(i)).afficherBombe(ter.getlab(),theme);
			Bomberman.perteVie(Bombesj.get(i).destruction(Bombesj, ter.getlab(), j2,j1, ListeBonus));		
	}
	for (int i=0; i< Bombesj2.size() ; i++) {
		(Bombesj2.get(i)).reconstruction(Bombesj,Bombesj2, ter.getlab()) ;	
	}
	for (int i=0; i< Bombesj1.size() ; i++) {
			(Bombesj1.get(i)).reconstruction(Bombesj,Bombesj1, ter.getlab()) ;	
	}
	Bonus.typeDeBonus(ListeBonus,theme) ;
	Bonus.afficherBonus (ListeBonus) ;
	Bonus.actionBonus( ListeBonus, j2) ;
	Bonus.actionBonus( ListeBonus, j1) ;
	
	
	
	

	j1.gameOver() ;
	j2.gameOver() ;

	
	if (j1.gameOver()== true ) {
		C = false ;
		D = true ;
	}
	StdDraw.show(25);
}

if ( D==true) {
	sonJeu.stopSon();
	sonFin.jouerSon();
}

while(D==true){
	Menu.afficherMenuFinDeJeu("images"+theme+"Menu/fin.jpg");
	StdDraw.show(25);
}


}
	

}


