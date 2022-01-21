package day220112.org.guiex.ex06.tableView;

import static day220112.org.guiex.ex06.R.columnNames;
import static day220112.org.guiex.ex06.R.dao;
import static day220112.org.guiex.ex06.R.daoDB;
import static day220112.org.guiex.ex06.R.data;
import static day220112.org.guiex.ex06.R.model;
import static day220112.org.guiex.ex06.R.scrollPane;
import static day220112.org.guiex.ex06.R.table;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableSet{
	public TableSet() {
		columnNames = new Vector<String>();
		columnNames.add("IDX");	
		columnNames.add("NAME");
		columnNames.add("EMAIL");
		columnNames.add("PHONE");
		columnNames.add("GENDER");
		// Object[][] 배열을 대체하는 코드
//		data = dao.selectAll();
		data = daoDB.selectAll();
		
		model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
	}
	
}
