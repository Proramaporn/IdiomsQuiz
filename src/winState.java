import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

public class winState{
  private JFrame f = new JFrame("Idioms Quiz");
  private ImageIcon imgicon = new ImageIcon("Resources/Logo/logo2.png");
  private JLabel backGround = new JLabel();
  private JButton play = new JButton();
  private JButton quit = new JButton();
  private Clip clip;
  private Clip playag;
  private Clip quitt;

  public winState(){

    f.setIconImage(imgicon.getImage());
    f.setSize(805, 890);
    f.setLocation(500, 50);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout( null );
    playMusic();
    backGround.setLocation(0,0);
    backGround.setSize(850,850);
    backGround.setIcon(new ImageIcon ("Resources/Background/winback2.jpg"));

    Color c1 = new Color(255,204,81);
    play.setLocation ( 151, 500 );
    play.setSize (200,100);
    play.setBackground (c1);
    play.setIcon(new ImageIcon ("Resources/Picbutton/play.png"));

    Color c2 = new Color(255,48,49);
    quit.setLocation ( 453, 500 );
    quit.setSize (200,100);
    quit.setBackground (c2);
    quit.setIcon(new ImageIcon ("Resources/Picbutton/quit.png"));

    f.add(play);
    f.add(quit);
    f.add(backGround);

    f.setVisible(true);

    play.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        playMusicClickplay();
        //answer is Right
        if (clip.isRunning()) clip.stop();
        new GUIGame();
        f.dispose();
        }
    });

    quit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        playMusicClickQuit();
        //answer is Right
        if (clip.isRunning()) clip.stop();
        System.exit(0);
        }
    });
  }

  public void playMusic() {
      try {
        // Open an audio input stream.
        URL url = this.getClass().getClassLoader().getResource("Resources/Music/congregation.wav");
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

  public void playMusicClickplay() {
      try {
        // Open an audio input stream.
        URL url = this.getClass().getClassLoader().getResource("Resources/Music/play.wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
        // Get a sound clip resource.
        playag = AudioSystem.getClip();
        // Open audio clip and load samples from the audio input stream.
        playag.open(audioIn);
        playag.start();
      } catch (UnsupportedAudioFileException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
     } catch (LineUnavailableException e) {
        e.printStackTrace();
      }
  }

  public void playMusicClickQuit() {
      try {
        // Open an audio input stream.
        URL url = this.getClass().getClassLoader().getResource("Resources/Music/right.wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
        // Get a sound clip resource.
        quitt = AudioSystem.getClip();
        // Open audio clip and load samples from the audio input stream.
        quitt.open(audioIn);
        quitt.start();
      } catch (UnsupportedAudioFileException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
     } catch (LineUnavailableException e) {
        e.printStackTrace();
      }
  }
}
