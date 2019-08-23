package com.entity;

import java.awt.Graphics;

import javax.swing.RepaintManager;

import com.action.ActionAble;
import com.util.GetImageUtil;

/**
* @ClassName: BackGround
* @Description: 背景
* @author Crimson_wdc
* @date 2019年8月23日 下午3:34:55
*
*/
public class BackGround extends Gameobj implements ActionAble{
	private int speed;
    public BackGround() {
		// TODO Auto-generated constructor stub
	} 
    public BackGround(int x,int y,String imgName){
    	this.x = x;
    	this.y = y;
    	this.img = GetImageUtil.getImg(imgName);
    	this.speed = 1;
    	
    }
	@Override
	public void move() {
		x -= speed;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
		move();
	}
    
}
