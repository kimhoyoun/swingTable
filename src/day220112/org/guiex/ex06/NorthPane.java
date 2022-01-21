package day220112.org.guiex.ex06;

import static day220112.org.guiex.ex06.R.rb3;
import static day220112.org.guiex.ex06.R.rb4;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
public class NorthPane extends JPanel {

	
	public NorthPane() {
		ButtonGroup group = new ButtonGroup();
		JPanel radio = new JPanel(new GridLayout(1,2));
		group.add(rb3);
		group.add(rb4);
		
		radio.add(rb3);
		radio.add(rb4);
		this.add(radio);
	}
}
