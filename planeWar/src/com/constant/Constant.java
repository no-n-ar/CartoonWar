package com.constant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
* @ClassName: Constant
* @Description: 窗口大小
* @author Crimson_wdc
* @date 2019年8月23日 下午3:37:39
*
*/
public class Constant {
	public static Properties prop = new Properties();
	static Integer Game_WIDTH;
	static Integer Game_HEIGHT;
	static 
	{
		InputStream inStream = Constant.class.getResourceAsStream("/game.properties");
	    try {
			prop.load(inStream);
			Game_WIDTH = Integer.parseInt(prop.getProperty("GAME_WIDTH"));
			Game_HEIGHT = Integer.parseInt(prop.getProperty("GAME_HEIGHT"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static final Integer GAMEWIDTH = Game_WIDTH ;
    public static final Integer GAMEHEIGHT = Game_HEIGHT;
  
}
