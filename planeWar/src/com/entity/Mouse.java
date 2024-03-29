package com.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.util.List;

import com.action.ActionAble;
import com.client.GameClient;
import com.constant.Constant;
import com.util.GetImageUtil;
import com.util.singlePlay;

/**
* @ClassName: Mouse
* @Description: 飞机类
* @author Crimson_wdc
* @date 2019年8月23日 下午3:34:38
*
*/
public class Mouse extends Gameobj implements ActionAble{
	singlePlay play = new singlePlay();
    private int speed;
    private boolean left,right,up,down;
    private GameClient gc;
    public boolean IsGood;
    // 添加飞机子弹等级
    public int Bulletlevel = 1;
    // 加血值
    public int blood;
	public Mouse() {
	   
   }
	
   public Mouse(int x,int y,String imgName,GameClient gc,boolean IsGood) {
	  this.x = x;
	  this.y = y;
	  this.img = GetImageUtil.getImg(imgName);
	  this.speed = 30;
	  this.gc = gc;
	  this.IsGood = IsGood;
	  this.blood = 200;
   }
    // 移动方法
    public void move() {
       if(left) {
    	 x -= speed;  
       }
       if(right) {
    	 x += speed;  
       }
       if(up) {
    	 y -= speed;  
       }
       if(down) {
    	 y += speed;  
       }
       outOfBound();
    }
    
    // 画飞机
    public void draw(Graphics g) {
    g.drawImage(img, x, y,null);
    move();
    g.drawString("飞机当前血量为"+blood,gc.mouses.get(0).x-8,gc.mouses.get(0).y-15);
    }
    
    // 处理边界问题
    public void outOfBound() {
    	if(y<=30) {
    		y = 30;
    	}
    	if(x<=-25) {
    		x = -25;
    	}
    	if(y>=Constant.GAMEHEIGHT-img.getHeight(null)) {
    		y = Constant.GAMEHEIGHT-img.getHeight(null);
    	}
    	if(x>=Constant.GAMEWIDTH-img.getWidth(null)) {
    		x = Constant.GAMEWIDTH-img.getWidth(null);
    	}
    }
    
    // 键盘按下
    public void keyPressed(KeyEvent e) {
    	switch(e.getKeyCode()) {
    	case KeyEvent.VK_LEFT:
    		left = true;
    		break;
    	case KeyEvent.VK_RIGHT:
    		right = true;
    		break;
    	case KeyEvent.VK_UP:
    		up = true;
    		break;
    	case KeyEvent.VK_DOWN:
    		down = true;
    		break;
    	case KeyEvent.VK_Z:
    		fire();
    		break;
    	default:
    		break;
    	}
    }
    
    // 键盘释放
    public void keyReleased(KeyEvent e) {
    	switch(e.getKeyCode()) {
    	case KeyEvent.VK_LEFT:
    		left = false;
    		break;
    	case KeyEvent.VK_RIGHT:
    		right = false;
    		break;
    	case KeyEvent.VK_UP:
    		up = false;
    		break;
    	case KeyEvent.VK_DOWN:
    		down = false;
    		break;
    	default:
    		break;
    	}
    }
    
    // 老鼠发射子弹
    public void fire() {
    	play.play("com/sound/SOUND_BOOSTER_COIN.mp3");
    	Bullet bullet = new Bullet(x+this.img.getWidth(null),y+this.img.getHeight(null)/2 -18,"com/img/bullet/BULLET_CHAR_ANNA_0"+Bulletlevel+".png",gc,true);
    	
    	if(gc.mouses.size()!=0) {
    		gc.bullets.add(bullet);
    	}
    }
    
    // 获取到敌人的矩形
  	public Rectangle getRec() {
  		return new Rectangle(x,y,this.img.getWidth(null),this.img.getHeight(null));
  	}
  	
  	// 检测我方角色碰到道具
  	public void containItem(Prop prop) {
  		if(this.getRec().intersects(prop.getRect())) {
  			// 移除道具
  		    gc.props.remove(prop);
  		    // 更改子弹等级
  		    if(this.Bulletlevel>=6) {
  		        this.Bulletlevel = 6;
  		    }else {
  		    	this.Bulletlevel += 1; 
  		    }
  		}
  	}
  	
  	// 检测我方角色碰到多个道具
  	public void containItem(List<Prop> props) {
  		if(props == null) {
  			return;
  		}else {
  			for(int i = 0;i<props.size();i++) {
  				containItem(props.get(i));
  			}
  		}
  	}
}
