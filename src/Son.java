import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Son {
	Clip clip ;
	File Son ;
	
	public Son( File a){
		this.Son = a ;
	}
	

	public void jouerSon()  {
		try {
			clip= AudioSystem.getClip() ;
			clip.open(AudioSystem.getAudioInputStream(this.Son)) ;
			clip.start();

		} catch(Exception e) {
			
		}
		
	}

	public void jouerBoucleSon(File Son)  {
		try {
			clip= AudioSystem.getClip() ;
			clip.open(AudioSystem.getAudioInputStream(Son)) ;
			clip.loop(Clip.LOOP_CONTINUOUSLY);

		} catch(Exception e) {
			
		}
		
	}
	
	
	
	public void stopSon()  {
		this.clip.stop();
	}
			
	
}
