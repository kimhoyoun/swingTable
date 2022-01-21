package day220112.org.guiex.ex06;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import day220112.org.guiex.ex06.model.SaramDao;
import day220112.org.guiex.ex06.model.SaramDaoDB;
import day220112.org.guiex.ex06.model.SaramDto;

public abstract class R {
	public static JTable table;
	public static DefaultTableModel model;
	public static JScrollPane scrollPane;
	public static String manwoman;
	
	public static Vector data;
	public static Vector<String> columnNames;
	
	public static SaramDto saram;
	
	public static JPanel tablePane;
	public static JPanel picturePane;
	
	public static final SaramDao dao = new SaramDao();
	public static final SaramDaoDB daoDB = new SaramDaoDB();
	
	public static final JTextField txtFld1 = new JTextField(10);
	public static final JTextField txtFld2 = new JTextField(10);
	public static final JTextField txtFld3 = new JTextField(10);
	public static final JTextField txtFld4 = new JTextField(10);
	
	public static final JInternalFrame AppleFrame = new JInternalFrame("Apple",true,true,true,true);
	public static final JInternalFrame BananaFrame = new JInternalFrame("Banana",true,true,true,true);
	public static final JInternalFrame CarFrame = new JInternalFrame("Car",true,true,true,true);
	public static final JInternalFrame AirplaneFrame = new JInternalFrame("Airplane",true,true,true,true);
	
	public static final ImageIcon img1 = new ImageIcon("Apple.png");
	public static final ImageIcon img2 = new ImageIcon("Banana.png");
	public static final ImageIcon img3 = new ImageIcon("Car.png");
	public static final ImageIcon img4 = new ImageIcon("Airplane.png");

	public static final JButton allBtn = new JButton("All");
	public static final JButton inputBtn = new JButton("Input");
	public static final JButton searchBtn = new JButton("Search");
	public static final JButton modifyBtn = new JButton("Modify");
	public static final JButton deleteBtn = new JButton("Delete");
	public static final JButton finishBtn = new JButton("Finish");
	
	
	public static final JCheckBox cb1 = new JCheckBox("Apple");
	public static final JCheckBox cb2 = new JCheckBox("Banana");
	public static final JCheckBox cb3 = new JCheckBox("Car");
	public static final JCheckBox cb4 = new JCheckBox("Airplane");
	
	public static final JRadioButton rb1 = new JRadioButton("남자");
	public static final JRadioButton rb2 = new JRadioButton("여자");
	public static final JRadioButton rb3 = new JRadioButton("Table View",true);
	public static final JRadioButton rb4 = new JRadioButton("Picture View");
	
	
}
