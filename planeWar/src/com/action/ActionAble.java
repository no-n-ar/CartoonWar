package com.action;

import java.awt.Graphics;

/**
* @ClassName: ActionAble
* @Description: 行为接口
* @author Crimson_wdc
* @date 2019年8月23日 下午3:38:10
*
*/
public interface ActionAble {
    //移动
	void move();
	//画图片
	void draw(Graphics g);
}
