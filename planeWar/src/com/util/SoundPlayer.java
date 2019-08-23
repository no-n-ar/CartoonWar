package com.util;

import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;


/**
* @ClassName: SoundPlayer
* @Description: ��������
* @author Crimson_wdc
* @date 2019��8��23�� ����3:32:45
*
*/
public class SoundPlayer extends Thread {
	private String mp3Name;
    public SoundPlayer() {
    	
    }
    public SoundPlayer(String mp3Name) {
    	this.mp3Name = mp3Name;
    }
    public void run() {
    	for(;;) {
    		InputStream resourceAsStream = SoundPlayer.class.getClassLoader().getResourceAsStream(mp3Name);
    	try {
			AdvancedPlayer advancedPlayer = new AdvancedPlayer(resourceAsStream);
			advancedPlayer.play();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
    	
    }
}
