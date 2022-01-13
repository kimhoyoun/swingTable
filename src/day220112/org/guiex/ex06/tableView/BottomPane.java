package day220112.org.guiex.ex06.tableView;

import static day220112.org.guiex.ex06.R.*;
import static day220112.org.guiex.ex06.R.deleteBtn;
import static day220112.org.guiex.ex06.R.finishBtn;
import static day220112.org.guiex.ex06.R.inputBtn;
import static day220112.org.guiex.ex06.R.modifyBtn;
import static day220112.org.guiex.ex06.R.searchBtn;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomPane extends JPanel {
	
	public BottomPane() {
//		allBtn.setPreferredSize(new Dimension(40,20));
//		inputBtn.setPreferredSize(new Dimension(64,20));
//		searchBtn.setPreferredSize(new Dimension(74,20));
//		modifyBtn.setPreferredSize(new Dimension(79,20));
//		deleteBtn.setPreferredSize(new Dimension(74,20));
//		finishBtn.setPreferredSize(new Dimension(67,20));
		
		this.add(allBtn);
		this.add(inputBtn);
		this.add(searchBtn);
		this.add(modifyBtn);
		this.add(deleteBtn);
		this.add(finishBtn);
		
	}
}
