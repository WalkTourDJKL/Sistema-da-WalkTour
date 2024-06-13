package controle;

import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicPlayer {
    
    private Clip clip;

    public MusicPlayer(String filePath) {
        try (InputStream audioSrc = getClass().getResourceAsStream(filePath)) {
            if (audioSrc == null) {
                System.err.println("Arquivo de áudio não encontrado: " + filePath);
                return;
            }
            InputStream bufferedIn = new java.io.BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    public void play() {
        if (clip != null && !clip.isRunning()) {
            clip.setFramePosition(0); // Começa a música do início
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop infinito
        }
    }
    
    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

}
