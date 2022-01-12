package day220112.org.guiex.ex06;

import static day220112.org.guiex.ex06.R.allBtn;
import static day220112.org.guiex.ex06.R.columnNames;
import static day220112.org.guiex.ex06.R.data;
import static day220112.org.guiex.ex06.R.dao;
import static day220112.org.guiex.ex06.R.deleteBtn;
import static day220112.org.guiex.ex06.R.finishBtn;
import static day220112.org.guiex.ex06.R.inputBtn;
import static day220112.org.guiex.ex06.R.model;
import static day220112.org.guiex.ex06.R.modifyBtn;
import static day220112.org.guiex.ex06.R.scrollPane;
import static day220112.org.guiex.ex06.R.searchBtn;
import static day220112.org.guiex.ex06.R.table;
import static day220112.org.guiex.ex06.R.txtFld1;
import static day220112.org.guiex.ex06.R.txtFld2;
import static day220112.org.guiex.ex06.R.txtFld3;
import static day220112.org.guiex.ex06.R.txtFld4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import day220111.org.guiex.myframe.MyJFrame;

public class TestJTable02 extends MyJFrame {

	public TestJTable02() {
		super("JTable 연습", 640, 480);
	}

	private void mkTableData() {

		columnNames = new Vector<String>();
		columnNames.add("IDX");
		columnNames.add("NAME");
		columnNames.add("EMAIL");
		columnNames.add("PHONE");

		// Object[][] 배열을 대체하는 코드
		data = dao.selectAll();
	}

	@Override
	protected void displayLayer() {
		mkTableData();
		contentPan = getContentPane();

		contentPan.add(BorderLayout.WEST, new LeftPane());
		contentPan.add(BorderLayout.SOUTH, new BottomPane());

		model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		contentPan.add(scrollPane);
	}

	private void addRowData() {
		model.setDataVector(null, columnNames);
		model.addRow(new Object[] { 3, "aaa", "aaa@naver.com", "010-1221-2222" });
		model.addRow(new Object[] { 4, "bbb", "bbb@naver.com", "010-3421-5222" });
	}
	
	
	// 리스트 출력
	private void displayList(Vector<Vector> vectorList) {
		model.setDataVector(null, columnNames);
		Vector<Vector> saramList = vectorList;
		for (Vector vector : saramList) {
			model.addRow(vector);
		}
	}
	
	private void displayAll() {
		model.setDataVector(null, columnNames);
		Vector<Vector> saramList = dao.selectAll();
		for (Vector vector : saramList) {
			model.addRow(vector);
		}
	}
	
	@Override
	protected void actionEvt() {
		// 버튼 이벤트 핸들러 추가
		allBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				displayAll();
			}
		});

		inputBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// textField 데이터를 읽어온다.
				String name = txtFld2.getText();
				txtFld2.setText("");
				String email = txtFld3.getText();
				txtFld3.setText("");
				String phone = txtFld4.getText();
				txtFld4.setText("");
				
				// TableModel에 반영해주기
				// dao에 저장 후
				// list를 다시 그려준다.

				boolean in = dao.insert(new SaramDto(0, name, email, phone));
				if(in) {
					JOptionPane.showMessageDialog(TestJTable02.this, "입력 완료!");
					// list를 다시 그려 준다.
					// list를 그려주는 displayList 메소드
					displayAll();
				}else {
					JOptionPane.showMessageDialog(TestJTable02.this, "정보를 전부 입력해주세요!");
				}
			}

		});

		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = txtFld2.getText();
				txtFld2.setText("");
				
				Vector<Vector> vector = dao.search(new SaramDto(0, name, null, null));
				
				if (vector != null) {
					JOptionPane.showMessageDialog(TestJTable02.this, "검색된 정보를 출력합니다!");
					displayList(vector);
				} else {
					JOptionPane.showMessageDialog(TestJTable02.this, "해당 정보가 없습니다!");
				}

			}
		});

		modifyBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txtFld1.getText();
				txtFld1.setText("");
				String name = txtFld2.getText();
				txtFld2.setText("");
				String email = txtFld3.getText();
				txtFld3.setText("");
				String phone = txtFld4.getText();
				txtFld4.setText("");
				
				// 숫자가 입력 안됐을 경우 예외처리로 idx 0으로 해줌
				int idx = 0;
				try {
					idx = Integer.parseInt(id);
				}catch(NumberFormatException r) {
					idx = 0;
					JOptionPane.showMessageDialog(TestJTable02.this, "ID는 필수사항이며, 숫자만 입력하세요!");
				}
				
				Vector vector = dao.modify(new SaramDto(idx, name, email, phone));

				if (vector != null) {
					JOptionPane.showMessageDialog(TestJTable02.this, "수정된 정보를 출력합니다!");
					displayAll();
				}else {
					JOptionPane.showMessageDialog(TestJTable02.this, "정보가 잘못되어 수정할 수 없습니다!");
				}
			}
		});

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txtFld1.getText();
				txtFld1.setText("");
				String name = txtFld2.getText();
				txtFld2.setText("");
				String email = txtFld3.getText();
				txtFld3.setText("");
				String phone = txtFld4.getText();
				txtFld4.setText("");
				
				int idx = 0;
				try {
					idx = Integer.parseInt(id);
				}catch(NumberFormatException r) {
					idx = 0;
					JOptionPane.showMessageDialog(TestJTable02.this, "ID는 필수사항이며, 숫자만 입력하세요!");
				}
				
				boolean del = dao.delete(new SaramDto(idx, name, email, phone));
				
				if(del) {
					JOptionPane.showMessageDialog(TestJTable02.this, "삭제 되었습니다!");
					displayAll();
				}else {
					JOptionPane.showMessageDialog(TestJTable02.this, "삭제할 수 없습니다.");
				}
				
			}
		});

		finishBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(TestJTable02.this, "goodbye");
				dispose();
				System.exit(0);
			}
		});

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JTable tbl = (JTable) e.getSource();

				int row = tbl.getSelectedRow();

				Integer no = (Integer) model.getValueAt(row, 0);
				String name = (String) model.getValueAt(row, 1);
				String email = (String) model.getValueAt(row, 2);
				String phone = (String) model.getValueAt(row, 3);

				txtFld1.setText(no.toString());
				txtFld2.setText(name);
				txtFld3.setText(email);
				txtFld4.setText(phone);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

	public static void main(String[] args) {
		new TestJTable02().setVisible(true);
	}

}
