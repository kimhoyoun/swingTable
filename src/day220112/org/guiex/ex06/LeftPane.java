package day220112.org.guiex.ex06;


import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import static day220112.org.guiex.ex06.R.*;

public class LeftPane extends JPanel{
	
	public LeftPane() {
		JPanel title = new JPanel();
		title.add(new JLabel("::::::::::   Input Data   ::::::::::"));
		JPanel rowPan1 = new JPanel();
		rowPan1.add(new JLabel("ID : "));
		rowPan1.add(txtFld1);
		
		JPanel rowPan2 = new JPanel();
		rowPan2.add(new JLabel("Name : "));
		rowPan2.add(txtFld2);
		
		JPanel rowPan3 = new JPanel();
		rowPan3.add(new JLabel("Email : "));
		rowPan3.add(txtFld3);
		
		JPanel rowPan4 = new JPanel();
		rowPan4.add(new JLabel("Phone : "));
		rowPan4.add(txtFld4);
		
		JPanel gridPan = new JPanel(new GridLayout(5,1));
		gridPan.add(title);
		gridPan.add(rowPan1);
		gridPan.add(rowPan2);
		gridPan.add(rowPan3);
		gridPan.add(rowPan4);
		
		this.add(gridPan);
	}
}

