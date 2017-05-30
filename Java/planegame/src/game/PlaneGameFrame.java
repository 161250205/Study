package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import fxx.util.GameUtil;
import fxx.util.MyFrame;

public class PlaneGameFrame extends MyFrame{
	KeyBoard kb =new KeyBoard();
	Image bg = GameUtil.getImage("images/bg.jpg");
	Plane plane = new Plane("images/plane.png",230,420);
	Blast boom = new Blast();
	Date starttime,endtime;
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	int numOfBullet = 30;
	boolean start=true;
	boolean playing =false;
	boolean blast =false;
	boolean end =false;
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		if(start){startdraw(g);}
		if(playing){playingdraw(g);}
		if(blast){blastdraw(g);}
		if(end){enddraw(g);}
	}
	
	public void startdraw(Graphics g){
		Color c=g.getColor();
		Font f=g.getFont();
		g.setFont(new Font("宋体", Font.BOLD, 80));
		g.setColor(new Color(255,255,255));
		g.drawString("特训", 170, 420);
		g.setFont(new Font("宋体", Font.BOLD, 30));
		g.drawString("回车键开始游戏",20, 80);
		g.setFont(f);
		g.setColor(c);
	}
	public void playingdraw(Graphics g){
		plane.draw(g);
		for(int i=0;i<numOfBullet;i++){
			Bullet b = (Bullet)bulletList.get(i);
			b.draw(g);
			blast=b.getRect().intersects(plane.getRect());
			if(blast){
				playing = false;
				endtime = new Date();
				break;
			}
		}
	}
	public void blastdraw(Graphics g){
		boom.draw(g, plane.x, plane.y);
		blast =false;
		end = true;
	}
	public void enddraw(Graphics g){
		float time = (endtime.getTime()-starttime.getTime())/1000;
		Color c=g.getColor();
		Font f=g.getFont();
		g.setFont(new Font("宋体", Font.BOLD, 50));
		g.setColor(new Color(255,255,255));
		g.drawString("游戏结束", 150, 420);
		g.setFont(new Font("宋体", Font.BOLD, 30));
		g.drawString("你坚持了"+time+"秒", 140, 470);
		g.drawString("ESC重新开始",20, 80);
		g.setFont(f);
		g.setColor(c);
	}
	
	public void launchFram(){
		super.launchFram();
		addKeyListener(kb);
		for(int i=0 ;i<numOfBullet;i++){
			Bullet b= new Bullet();
			bulletList.add(b);
		}
	}
	
	
	class KeyBoard extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
			if(e.getKeyCode()==10){
				start=false;
				playing=true;
				starttime = new Date();
			}
			if(e.getKeyCode()==e.VK_ESCAPE){
				end = false;
				for(Bullet b:bulletList){
					b.initial();
				}
				plane.initial();
				start=true;
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plane.cutDirection(e);
		}
		
	}
	public static void main(String[] args){
		PlaneGameFrame PGF =new PlaneGameFrame();
		PGF.launchFram();
	}
}
