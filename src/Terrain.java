import edu.princeton.cs.introcs.StdDraw;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
public class Terrain {
	

	int [][] lab = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,1,0},
					{0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,1,0,1,0},
					{0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,0},
					{0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0},
					{0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
					{0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0},
					{0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
					{0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0},
					{0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
					{0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0},
					{0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
					{0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0},
					{0,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
					{0,1,0,1,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0},
					{0,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}}; ;
	
	
	public int[][] getlab(){
		return lab;
	}
	 public static void afficherTerrain(int [][] lab, long time, String theme){
		 StdDraw.setXscale(-6.5,26.5);
		 StdDraw.setYscale(-1.5,17.5);
		 int dureeflammes = 500 ;

		for(int i=0; i < 17; i++){
			for(int j=0; j<21; j++){	
				if (lab[i][j]==0){
					
					
					if (j==0 || j==20) {
						StdDraw.picture(j, 16-i, "images"+theme+"Terrain/contour.png", 1, 1);
					}
					else if (i==0 || i==16) {
						StdDraw.picture(j, 16-i, "images"+theme+"Terrain/contour.png", 1, 1);
					}
					else {
			    	//if (i%2==0 && j%2==0){
			    		StdDraw.picture(j, 16-i, "images"+theme+"Terrain/indestructible.png", 1, 1);
					}
			    	//}
			    	/*if (i%2==1 && j%2==0){
						StdDraw.picture(j, 16-i, "images/Bmaison2.jpg", 1, 1);
			    	}
			    	if (i%2==0 && j%2==1){
						StdDraw.picture(j, 16-i, "images/Bmaison3.jpg", 1, 1);
			    	}
			    	if (i%2==1 && j%2==1) {
						StdDraw.picture(j, 16-i, "images/Bmaison4.jpg", 1, 1);
			    	}*/
	
			
				}	
				if (lab[i][j]==1 || lab[i][j]==3 ){	
					StdDraw.picture(j, 16-i, "images"+theme+"Terrain/circulable.png", 1, 1);
				}
				if (lab[i][j]==2){
					StdDraw.picture(j, 16-i, "images"+theme+"Terrain/destructible.png", 1, 1);
				}
				if (lab[i][j]==4 || lab[i][j]==5){
	
					StdDraw.picture(j, 16-i, "images"+theme+"Terrain/circulable.png", 1, 1);
					if (time-(dureeflammes*0) >System.currentTimeMillis() && 
							time-(dureeflammes*0.20) < System.currentTimeMillis()  ){
					StdDraw.picture(j, 16-i, "images"+theme+"Bombes/explosion1.png", 1, 1);
					}
					if (time-(dureeflammes*0.20) > System.currentTimeMillis() && 
							time-(dureeflammes*0.40) < System.currentTimeMillis() ){
					StdDraw.picture(j, 16-i, "images"+theme+"Bombes/explosion2.png", 1, 1);
					}
					if (time-(dureeflammes*0.40) > System.currentTimeMillis() && 
							time-(dureeflammes*0.60) < System.currentTimeMillis() ){
					StdDraw.picture(j, 16-i, "images"+theme+"Bombes/explosion3.png", 1, 1);
					}
					if (time-(dureeflammes*0.60) > System.currentTimeMillis()&& 
							time-(dureeflammes*0.80) < System.currentTimeMillis() ){
					StdDraw.picture(j, 16-i, "images"+theme+"Bombes/explosion4.png", 1, 1);
					}
					if (time-(dureeflammes*0.80) > System.currentTimeMillis() && 
							time-(dureeflammes*1) < System.currentTimeMillis() ){
					StdDraw.picture(j, 16-i, "images"+theme+"Bombes/explosion5.png", 1, 1);
					}
					if (time-(dureeflammes*0.30) > System.currentTimeMillis() && 
							time-(dureeflammes*0.20) < System.currentTimeMillis() ){
						StdDraw.picture(j, 16-i, "images"+theme+"Bombes/explosion4.png", 1, 1);
					}
					if (time-(dureeflammes*0.20) > System.currentTimeMillis() && 
							time-(dureeflammes*0.10) < System.currentTimeMillis() ){
						StdDraw.picture(j, 16-i, "images"+theme+"Bombes/explosion3.png", 1, 1);
					}
					if (time-(dureeflammes*0.10) > System.currentTimeMillis() && 
							time < System.currentTimeMillis() ){
						StdDraw.picture(j, 16-i, "images"+theme+"Bombes/explosion2.png", 1, 1);
					}
				
				
					
					
					
				}
			}
				
		}
		
	 }
	 
	 
}