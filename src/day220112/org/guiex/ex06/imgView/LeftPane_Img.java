package day220112.org.guiex.ex06.imgView;

import static day220112.org.guiex.ex06.R.cb1;
import static day220112.org.guiex.ex06.R.cb2;
import static day220112.org.guiex.ex06.R.cb3;
import static day220112.org.guiex.ex06.R.cb4;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
public class LeftPane_Img extends JPanel{
	
	
	
	public LeftPane_Img() {
		JPanel title = new JPanel();
		title.add(new JLabel("::::::::::   Image   ::::::::::"));
		
		JPanel list1 = new JPanel();
		list1.add(cb1);
		JPanel list2 = new JPanel();
		list2.add(cb2);
		JPanel list3 = new JPanel();
		list3.add(cb3);
		JPanel list4 = new JPanel();
		list4.add(cb4);
		
		JPanel grid = new JPanel(new GridLayout(5,1));
		grid.add(title);
		grid.add(list1);
		grid.add(list2);
		grid.add(list3);
		grid.add(list4);
		
		this.add(grid);
	}
}
