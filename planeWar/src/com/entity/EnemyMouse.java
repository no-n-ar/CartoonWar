package com.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import com.action.ActionAble;
import com.client.GameClient;
import com.util.GetImageUtil;

/**
* @ClassName: EnemyMouse
* @Description: 敌方单位
* @author Crimson_wdc
* @date 2019年8月23日 下午3:35:57
*
*/
public class EnemyMouse extends Mouse implements ActionAble{
    private Integer enemyType;
    private GameClient gc;
    private Integer speed;
    boolean IsGood;
    private Image[] imgs1 = {
    		GetImageUtil.getImg("com/img/enemy/01.png"),
    		GetImageUtil.getImg("com/img/enemy/02.png"),
    		GetImageUtil.getImg("com/img/enemy/03.png"),
    		GetImageUtil.getImg("com/img/enemy/04.png"),
    		GetImageUtil.getImg("com/img/enemy/05.png"),
    		GetImageUtil.getImg("com/img/enemy/06.png"),
    		GetImageUtil.getImg("com/img/enemy/07.png")
    };
	public EnemyMouse() {
    	
    }
    public EnemyMouse(int x,int y,int enemyType,GameClient gc,boolean IsGood) {
    	this.x = x;
    	this.y = y;
    	this.enemyType = enemyType;
    	this.gc = gc;
    	this.speed = 2;
    	this.IsGood = IsGood;
    }
  
    public void move() {
    	x -= speed;
    }
    
    int count = 0;
    
    public void draw(Graphics g) {
    	if(count>6) {
    		count = 0;
    	}
       g.drawImage(imgs1[count++], x, y, null);
       move();
       if(random.nextInt(500)>480) {
       fire();
       }
    }
    Random random = new Random();
    
    //敌人发火
    public void fire() {
    	Bullet bullet = new Bullet(x,y+imgs1[0].getHeight(null)/2,"com/img/eBullet/enemy.png",gc,false);
    	gc.bullets.add(bullet);
    }
    
    //获取到敌人的矩形
  	public Rectangle getRec() {
  		return new Rectangle(x,y,this.imgs1[0].getWidth(null),this.imgs1[0].getHeight(null));
  	}
}
