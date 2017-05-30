package fxx.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import fxx.util.Constant;
import fxx.util.GameUtil;
import fxx.util.MyFrame;

public class SolarFrame extends MyFrame {
	Image background = GameUtil.getImage("images/bg.jpg");
	Star sun = new Star("images/sun.jpg",Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2);
	Planet earth =new Planet("images/Earth.jpg",sun,150,100,0.05);
	Planet moon =new Planet("images/moon.jpg",earth,20,20,0.1,true);
	Planet mars =new Planet("images/Mars.jpg",sun,200,150,0.03);
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, null);
		sun.draw(g);
		earth.draw(g);
		moon.draw(g);
		mars.draw(g);
	}
	public static void main(String[] args){
		SolarFrame s = new SolarFrame();
		s.launchFram();
	}
}


