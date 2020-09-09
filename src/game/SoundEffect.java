//Code modified from https://www3.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html

package game;
import java.io.*;

import javax.sound.sampled.*;
   
/**
 * This enum encapsulates all the sound effects of a game, so as to separate the sound playing
 * codes from the game codes.
 * 1. Define all your sound effect names and the associated wave file.
 * 2. To play a specific sound, simply invoke SoundEffect.SOUND_NAME.play().
 * 3. You might optionally invoke the static method SoundEffect.init() to pre-load all the
 *    sound files, so that the play is not paused while loading the file for the first time.
 * 4. You can use the static variable SoundEffect.volume to mute the sound.
 */
public enum SoundEffect {
           
	
	//===Player Sounds===
	//Girl (Zoe and Missy)
	GIRL_INTRO_1("/res/sounds/girl/intro1.wav"),
	GIRL_EVENT_1("/res/sounds/girl/event1.wav"),
	GIRL_OMEN_1("/res/sounds/girl/omen1.wav"),
	GIRL_ITEM_1("/res/sounds/girl/item1.wav"),
	GIRL_HURT_1("/res/sounds/girl/hurt1.wav"),
	GIRL_HEAL_1("/res/sounds/girl/heal1.wav"),
	GIRL_FALL_1("/res/sounds/girl/fall1.wav"),
	GIRL_INTRO_2("/res/sounds/girl/intro2.wav"),
	GIRL_LOW_PHYS("/res/sounds/girl/lowphys.wav"),
	GIRL_LOW_MENT("/res/sounds/girl/lowment.wav"),
	GIRL_DEATH("/res/sounds/girl/death.wav"),
	GIRL_HMM("/res/sounds/girl/hmm.wav"),
	//Boy (Brandon and Peter
	BOY_INTRO_1("/res/sounds/boy/intro1.wav"),
	BOY_EVENT_1("/res/sounds/boy/event1.wav"),
	BOY_OMEN_1("/res/sounds/boy/omen1.wav"),
	BOY_ITEM_1("/res/sounds/boy/item1.wav"),
	BOY_HURT_1("/res/sounds/boy/hurt1.wav"),
	BOY_HEAL_1("/res/sounds/boy/heal1.wav"),
	BOY_FALL_1("/res/sounds/boy/fall1.wav"),
	BOY_INTRO_2("/res/sounds/boy/intro2.wav"),
	BOY_LOW_PHYS("/res/sounds/boy/lowphys.wav"),
	BOY_LOW_MENT("/res/sounds/boy/lowment.wav"),
	BOY_DEATH("/res/sounds/boy/death.wav"),
	BOY_HMM("/res/sounds/boy/hmm.wav"),
	//Cheer(Jenny and Heather)
	CHEER_INTRO_1("/res/sounds/cheer/intro1.wav"),
	CHEER_EVENT_1("/res/sounds/cheer/event1.wav"),
	CHEER_OMEN_1("/res/sounds/cheer/omen1.wav"),
	CHEER_ITEM_1("/res/sounds/cheer/item1.wav"),
	CHEER_HURT_1("/res/sounds/cheer/hurt1.wav"),
	CHEER_HEAL_1("/res/sounds/cheer/heal1.wav"),
	CHEER_FALL_1("/res/sounds/cheer/fall1.wav"),
	CHEER_INTRO_2("/res/sounds/cheer/intro2.wav"),
	CHEER_LOW_PHYS("/res/sounds/cheer/lowphys.wav"),
	CHEER_LOW_MENT("/res/sounds/cheer/lowment.wav"),
	CHEER_DEATH("/res/sounds/cheer/death.wav"),
	CHEER_HMM("/res/sounds/cheer/hmm.wav"),
	//Woman(Zostra and Vivian)
	WOMAN_INTRO_1("/res/sounds/woman/intro1.wav"),
	WOMAN_EVENT_1("/res/sounds/woman/event1.wav"),
	WOMAN_OMEN_1("/res/sounds/woman/omen1.wav"),
	WOMAN_ITEM_1("/res/sounds/woman/item1.wav"),
	WOMAN_HURT_1("/res/sounds/woman/hurt1.wav"),
	WOMAN_HEAL_1("/res/sounds/woman/heal1.wav"),
	WOMAN_FALL_1("/res/sounds/woman/fall1.wav"),
	WOMAN_INTRO_2("/res/sounds/woman/intro2.wav"),
	WOMAN_LOW_PHYS("/res/sounds/woman/lowphys.wav"),
	WOMAN_LOW_MENT("/res/sounds/woman/lowment.wav"),
	WOMAN_DEATH("/res/sounds/woman/death.wav"),
	WOMAN_HMM("/res/sounds/woman/hmm.wav"),
	//Jock(Ox and Darrin)
	JOCK_INTRO_1("/res/sounds/jock/intro1.wav"),
	JOCK_EVENT_1("/res/sounds/jock/event1.wav"),
	JOCK_OMEN_1("/res/sounds/jock/omen1.wav"),
	JOCK_ITEM_1("/res/sounds/jock/item1.wav"),
	JOCK_HURT_1("/res/sounds/jock/hurt1.wav"),
	JOCK_HEAL_1("/res/sounds/jock/heal1.wav"),
	JOCK_FALL_1("/res/sounds/jock/fall1.wav"),
	JOCK_INTRO_2("/res/sounds/jock/intro2.wav"),
	JOCK_LOW_PHYS("/res/sounds/jock/lowphys.wav"),
	JOCK_LOW_MENT("/res/sounds/jock/lowment.wav"),
	JOCK_DEATH("/res/sounds/jock/death.wav"),
	JOCK_HMM("/res/sounds/jock/hmm.wav"),
	//Old(Rheinhardt and Longfellow
	OLD_INTRO_1("/res/sounds/old/intro1.wav"),
	OLD_EVENT_1("/res/sounds/old/event1.wav"),
	OLD_OMEN_1("/res/sounds/old/omen1.wav"),
	OLD_ITEM_1("/res/sounds/old/item1.wav"),
	OLD_HURT_1("/res/sounds/old/hurt1.wav"),
	OLD_HEAL_1("/res/sounds/old/heal1.wav"),
	OLD_FALL_1("/res/sounds/old/fall1.wav"),
	OLD_INTRO_2("/res/sounds/old/intro2.wav"),
	OLD_LOW_PHYS("/res/sounds/old/lowphys.wav"),
	OLD_LOW_MENT("/res/sounds/old/lowment.wav"),
	OLD_DEATH("/res/sounds/old/death.wav"),
	OLD_HMM("/res/sounds/old/hmm.wav"),
	//Sound Effects
	DOOROPEN("/res/sounds/effects/door_open.wav"), // door opening
	FOOTSTEPS("/res/sounds/effects/footsteps.wav"),
	EVENT("/res/sounds/effects/event.wav"),
	OMEN("/res/sounds/effects/omen.wav"),
	ITEM("/res/sounds/effects/item.wav"),
	DICE("/res/sounds/effects/dice.wav"),
	LIGHTNING("/res/sounds/effects/lightning.wav"),
	TITLE_LOOP("/res/sounds/effects/titleloop.wav"),
	BACKGROUND("/res/sounds/effects/background.wav"),
	HAUNT("/res/sounds/effects/haunt.wav"),
	GOODEND("/res/sounds/effects/goodend.wav"),
	BADEND("/res/sounds/effects/badend.wav"),
	GLASS("/res/sounds/effects/glass.wav"),
	BELL1("/res/sounds/effects/bell1.wav"),
	BELL2("/res/sounds/effects/bell2.wav"),
	BELL3("/res/sounds/effects/bell3.wav"),
	HEART("/res/sounds/effects/heart.wav"),
	FURNACE("/res/sounds/effects/furnace.wav"),
	PUNCH("/res/sounds/effects/punch.wav"),
	CLICK("/res/sounds/effects/click.wav");
	 
   
   // Nested class for specifying volume
   public static enum Volume {
      MUTE, LOW, MEDIUM, HIGH
   }
   
   public static Volume volume = Volume.LOW;
   
   // Each sound effect has its own clip, loaded with its own sound file.
   private Clip clip;
   
   // Constructor to construct each element of the enum with its own sound file.
   SoundEffect(String soundFileName) {
      try {
         // Set up an audio input stream piped from the sound file.
         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(soundFileName));
         // Get a clip resource.
         clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioInputStream);
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }
   
   // Play or Re-play the sound effect from the beginning, by rewinding.
   public void play() {
      if (volume != Volume.MUTE) {
         if (clip.isRunning())
            clip.stop();   // Stop the player if it is still running
         clip.setFramePosition(0); // rewind to the beginning
         clip.start();     // Start playing
      }
   }
   
   //Method to loop sound over and over
   public void loop()
   {
	   clip.setFramePosition(0);
	   clip.loop(Clip.LOOP_CONTINUOUSLY);
   }
   
   //Method to stop a sound
   public void stop()
   {
	   clip.stop();
   }
   // Optional static method to pre-load all the sound files.
   public static void init() {
      values(); // calls the constructor for all the elements
   }
}