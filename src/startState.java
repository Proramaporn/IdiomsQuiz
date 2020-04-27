import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

public class startState{
  private JFrame f = new JFrame("Idioms Quiz");
  private ImageIcon imgicon = new ImageIcon("Resources/Logo/logo2.png");
  private JLabel backGround = new JLabel();
  private JButton Go = new JButton();
  private boolean stopMusic = false;
  private Clip clip;
  private Clip click;

  public startState(){

    f.setIconImage(imgicon.getImage());
    f.setSize(805, 890);
    f.setLocation(500, 50);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout( null );
    playMusic();

    backGround.setLocation(0,0);
    backGround.setSize(850,850);
    backGround.setIcon(new ImageIcon ("Resources/Background/startback7.jpg"));

    Color c1 = new Color(112,0,1);
    Go.setLocation ( 302, 500 );
    Go.setSize (200,100);
    Go.setBackground (c1);
    Go.setIcon(new ImageIcon ("Resources/Picbutton/start.png"));

    f.add(Go);
    f.add(backGround);

    f.setVisible(true);

    Go.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        playMusicOnClick();
        if (clip.isRunning()) clip.stop();
        //answer is Right
        new GUIGame();
        f.dispose();
        }
    });
  }

  public void playMusic() {
      try {
        // Open an audio input stream.
        URL url = this.getClass().getClassLoader().getResource("Resources/Music/start.wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
        // Get a sound clip resource.
        clip = AudioSystem.getClip();
        // Open audio clip and load samples from the audio input stream.

        clip.open(audioIn);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-40.0f);
        clip.start();
        clip.loop(5);
      } catch (UnsupportedAudioFileException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
     } catch (LineUnavailableException e) {
        e.printStackTrace();
      }
  }

  public void playMusicOnClick() {
      try {
        // Open an audio input stream.
        URL url = this.getClass().getClassLoader().getResource("Resources/Music/right.wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
        // Get a sound clip resource.
        click = AudioSystem.getClip();
        // Open audio clip and load samples from the audio input stream.
        click.open(audioIn);
        click.start();
      } catch (UnsupportedAudioFileException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      } catch (LineUnavailableException e) {
        e.printStackTrace();
      }
  }
}
