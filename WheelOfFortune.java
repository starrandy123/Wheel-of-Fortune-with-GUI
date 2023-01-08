import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;

public class WheelOfFortune{                       // CLASS THAT ACTUALLY RUNS THE GAME

    static SoundBoard sb;
    public static void main(String [] args){
        sb = new SoundBoard();
        GUI game = new GUI();
        return;
    }

}

class SoundBoard{

    static Clip clip;
    static Clip clip2;
    static Clip clip5;
    static boolean music = true;
    URL url1 = this.getClass().getResource("music/price.wav");
    URL url2 = this.getClass().getResource("music/game.wav");
    URL url3 = this.getClass().getResource("music/press.wav");
    URL url4 = this.getClass().getResource("music/start1.wav");
    URL url5 = this.getClass().getResource("music/spin.wav");
    URL url6 = this.getClass().getResource("music/fail.wav");
    URL url7 = this.getClass().getResource("music/dub.wav");
    URL url8 = this.getClass().getResource("music/win2.wav");

    SoundBoard(){
      music();
      music = true;
    }

    public void music(){
       if(music == false) return;
        try{
            clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(url1);
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            music = true;
        }
        catch(Exception exc){
            System.out.println(exc);
            return;
        }
    }                                                                                 //GAMES SOUNDS
    public void music2(){
        if(music == false) return;
        try{
            clip2 = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(url2);
            clip2.open(ais);
            clip2.loop(Clip.LOOP_CONTINUOUSLY);
            music = true;
        }
        catch(Exception exc){
            System.out.println(exc);
            return;
        }
    }

    public void buttonpress(){
        if(music == false) return;
        try{
            Clip clip1;
            clip1 = AudioSystem.getClip();
            AudioInputStream ais1 = AudioSystem.getAudioInputStream(url3);
            clip1.open(ais1);
            clip1.start();
        }
        catch(Exception exc){
            System.out.println(exc);
            return;
        }
    }
    public void startpress(){
        Clip clip1;
        if(music == false) return;
        try{
            clip1 = AudioSystem.getClip();
            AudioInputStream ais1 = AudioSystem.getAudioInputStream(url4);
            clip1.open(ais1);
            clip1.start();
            //        System.out.println("Clip noise");
        }
        catch(Exception exc){
            System.out.println(exc);
            return;
        }
    }
    public void spinning(){
       if(music == false) return;
       try{
          clip5 = AudioSystem.getClip();
          AudioInputStream ais = AudioSystem.getAudioInputStream(url5);
          clip5.open(ais);
          clip5.loop(Clip.LOOP_CONTINUOUSLY);
        }
       catch(Exception exc){
          System.out.println(exc);
          return;
       }
    }

    public void endspin(){
       if(music == false) return;
       try{
          clip5.stop();
        }
       catch(Exception exc){
          System.out.println(exc);
          return;
       }
    }
    public void result(int result){
       if(music == false) return;
       if(result == 0){
          try{
          Clip clip1 = AudioSystem.getClip();
          AudioInputStream ais = AudioSystem.getAudioInputStream(url6);
          clip1.open(ais);
          clip1.start();
          }
          catch(Exception exc){
          System.out.println(exc);
       }
       }
       else if(result == 1){
          try{
          Clip clip1 = AudioSystem.getClip();
          AudioInputStream ais = AudioSystem.getAudioInputStream(url7);
          clip1.open(ais);
          clip1.start();
          }
          catch(Exception exc){
          System.out.println(exc);
       }
      }
    }
    public void win(){
       if(music == false) return;
       try{
          Clip clip1 = AudioSystem.getClip();
          AudioInputStream ais = AudioSystem.getAudioInputStream(url8);
          clip1.open(ais);
          clip1.start();
       }
       catch(Exception exc){
          System.out.println(exc);
       }
    }

    public void stopmainmusic(){
        clip.stop();
    }
    public void stopmainmusic2(){                   //contols used by audio button, toggles sounds and main background music
        try{
        clip2.stop();
        }
        catch(Exception e){
          return;
        }
    }
    public void stopmusic(){
       music = false;
    }
    public void startmusic(){
       music = true;
    }
};
