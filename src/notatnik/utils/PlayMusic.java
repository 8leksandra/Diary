package notatnik.utils;

import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class PlayMusic {

  public PlayMusic()  {

    try {
      FileInputStream fs = new FileInputStream("res/Odgłosy natury - Ptaki. Las.mp3");
      Player player = new Player(fs);
      player.play();

    } catch (Exception e) {
    	e.printStackTrace();
    }
  }
}