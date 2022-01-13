package day220112.org.guiex.ex06.imgView;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import day220111.org.guiex.myframe.MyJFrame;
import static day220112.org.guiex.ex06.R.*;
public class Pictureview extends MyJFrame{
	public Pictureview() {
		super("Picture 연습", 640, 480);
	}
	@Override
	protected void displayLayer() {
		contentPan = getContentPane();
		contentPan.add(BorderLayout.WEST,new LeftPane_Img());
		contentPan.add(BorderLayout.CENTER,new CenterPane_Img());
	}

	
	
	@Override
	protected void actionEvt() {
		cb1.addItemListener(new ItemListener() {
			boolean state = false;
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					state = true;
				}else {
					state = false;
				}
				
				if(state) {
					AppleFrame.setVisible(true);					
				}else {
					AppleFrame.setVisible(false);
				}
				
			}
		});
		
		cb2.addItemListener(new ItemListener() {
			boolean state = false;
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					state = true;
				}else {
					state = false;
				}
				
				if(state) {
					BananaFrame.setVisible(true);					
				}else {
					BananaFrame.setVisible(false);
				}
				
			}
		});
		
		cb3.addItemListener(new ItemListener() {
			boolean state = false;
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					state = true;
				}else {
					state = false;
				}
				
				if(state) {
					CarFrame.setVisible(true);					
				}else {
					CarFrame.setVisible(false);
				}
				
			}
		});
		
		cb4.addItemListener(new ItemListener() {
			boolean state = false;
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					state = true;
				}else {
					state = false;
				}
				
				if(state) {
					AirplaneFrame.setVisible(true);					
				}else {
					AirplaneFrame.setVisible(false);
				}
				
			}
		});
	}

	public static void main(String[] args) {
		new Pictureview().setVisible(true);
	}
	
}
