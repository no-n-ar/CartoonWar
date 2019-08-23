package com.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
* @ClassName: GetImageUtil
* @Description: ��ͼ����
* @author Crimson_wdc
* @date 2019��8��23�� ����3:33:23
*
*/
public class GetImageUtil {
    public static Image getImg(String imgName) {
    	URL resource = GetImageUtil.class.getClassLoader().getResource(imgName);
    	BufferedImage bufferedImage = null;
    	try {
			bufferedImage = ImageIO.read(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return bufferedImage;
    }
}
