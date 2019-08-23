package com.util;

import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

/**
* @ClassName: singlePlay
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Crimson_wdc
* @date 2019年8月23日 下午3:33:13
*
*/
public class singlePlay extends Thread{
	private String mp3Name;
    public singlePlay() {

    }
    
    public singlePlay(String mp3Name) {
    	this.mp3Name = mp3Name;
    }
    public void play(String mp3Name) {
    	singlePlay singleplay = new singlePlay(mp3Name);
    	singleplay.start();
    }
    public void run() {
    	InputStream resourceAsStream = SoundPlayer.class.getClassLoader().getResourceAsStream(mp3Name);
    	try {
			AdvancedPlayer advancedPlayer = new AdvancedPlayer(resourceAsStream);
			advancedPlayer.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
    	}
    	
    
}
