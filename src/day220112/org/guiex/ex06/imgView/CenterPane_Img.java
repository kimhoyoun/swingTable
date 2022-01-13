package day220112.org.guiex.ex06.imgView;

import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import static day220112.org.guiex.ex06.R.*;

import java.awt.Graphics;
public class CenterPane_Img extends JDesktopPane{
	
	public CenterPane_Img() {
		
		JPanel p1 = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(img1.getImage(),0,0,null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		JScrollPane scroll1 = new JScrollPane(p1);
		
		JPanel p2 = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(img2.getImage(),0,0,null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		JScrollPane scroll2 = new JScrollPane(p2);
		
		JPanel p3 = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(img3.getImage(),0,0,null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		JScrollPane scroll3 = new JScrollPane(p3);
		
		JPanel p4 = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(img4.getImage(),0,0,null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		JScrollPane scroll4 = new JScrollPane(p4);
		
		AppleFrame.add(scroll1);
		BananaFrame.add(scroll2);
		CarFrame.add(scroll3);
		AirplaneFrame.add(scroll4);
		
		AppleFrame.setBounds(50,50,225,185);
		BananaFrame.setBounds(60,60,190,180);
		CarFrame.setBounds(70,70,267,185);
		AirplaneFrame.setBounds(80,80,270,185);
		this.add(AirplaneFrame);
		this.add(CarFrame);
		this.add(BananaFrame);
		this.add(AppleFrame);
		
	}
}
