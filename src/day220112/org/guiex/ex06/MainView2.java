package day220112.org.guiex.ex06;

import static day220112.org.guiex.ex06.R.AirplaneFrame;
import static day220112.org.guiex.ex06.R.AppleFrame;
import static day220112.org.guiex.ex06.R.BananaFrame;
import static day220112.org.guiex.ex06.R.CarFrame;
import static day220112.org.guiex.ex06.R.allBtn;
import static day220112.org.guiex.ex06.R.cb1;
import static day220112.org.guiex.ex06.R.cb2;
import static day220112.org.guiex.ex06.R.cb3;
import static day220112.org.guiex.ex06.R.cb4;
import static day220112.org.guiex.ex06.R.columnNames;
import static day220112.org.guiex.ex06.R.daoDB;
import static day220112.org.guiex.ex06.R.deleteBtn;
import static day220112.org.guiex.ex06.R.finishBtn;
import static day220112.org.guiex.ex06.R.inputBtn;
import static day220112.org.guiex.ex06.R.manwoman;
import static day220112.org.guiex.ex06.R.model;
import static day220112.org.guiex.ex06.R.modifyBtn;
import static day220112.org.guiex.ex06.R.picturePane;
import static day220112.org.guiex.ex06.R.rb1;
import static day220112.org.guiex.ex06.R.rb2;
import static day220112.org.guiex.ex06.R.rb3;
import static day220112.org.guiex.ex06.R.rb4;
import static day220112.org.guiex.ex06.R.searchBtn;
import static day220112.org.guiex.ex06.R.table;
import static day220112.org.guiex.ex06.R.tablePane;
import static day220112.org.guiex.ex06.R.txtFld1;
import static day220112.org.guiex.ex06.R.txtFld2;
import static day220112.org.guiex.ex06.R.txtFld3;
import static day220112.org.guiex.ex06.R.txtFld4;
import static day220112.org.guiex.ex06.R.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import day220111.org.guiex.myframe.MyJFrame;
import day220112.org.guiex.ex06.imgView.CenterPane_Img;
import day220112.org.guiex.ex06.imgView.LeftPane_Img;
import day220112.org.guiex.ex06.model.SaramDto;
import day220112.org.guiex.ex06.tableView.BottomPane;
import day220112.org.guiex.ex06.tableView.LeftPane;
import day220112.org.guiex.ex06.tableView.TableSet;

public class MainView2 extends MyJFrame {
	
	public MainView2() {
		super("MainView", 640, 480);
	}

	@Override
	protected void displayLayer() {
	
		contentPan = getContentPane();
		tablePane = new JPanel(new BorderLayout());
		picturePane = new JPanel(new BorderLayout());
		
		tablePane.add(BorderLayout.WEST, new LeftPane());
		tablePane.add(BorderLayout.SOUTH, new BottomPane());
		
		new TableSet();
		tablePane.add(BorderLayout.CENTER, scrollPane);
		
		contentPan.add(BorderLayout.NORTH, new NorthPane());
		contentPan.add(BorderLayout.CENTER,tablePane);
		
		picturePane.add(BorderLayout.WEST, new LeftPane_Img());
		picturePane.add(BorderLayout.CENTER, new CenterPane_Img());
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
			Vector<Vector> saramList = daoDB.selectAll();
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
						
						String mf = manwoman;
						// TableModel에 반영해주기
						// daoDB에 저장 후
						// list를 다시 그려준다.

						boolean in = daoDB.insert(new SaramDto(0, name, email, phone, mf));
						if (in) {
							JOptionPane.showMessageDialog(MainView2.this, "입력 완료!");
							// list를 다시 그려 준다.
							// list를 그려주는 displayList 메소드
							displayAll();
						} else {
							JOptionPane.showMessageDialog(MainView2.this, "정보를 전부 입력해주세요!");
						}
					}

				});

				searchBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String name = txtFld2.getText();
						txtFld1.setText("");
						txtFld2.setText("");
						txtFld3.setText("");
						txtFld4.setText("");
						Vector<Vector> vector = daoDB.search(new SaramDto(0, name, null, null, null));

						if (vector != null) {
							JOptionPane.showMessageDialog(MainView2.this, "검색된 정보를 출력합니다!");
							displayList(vector);
						} else {
							JOptionPane.showMessageDialog(MainView2.this, "해당 정보가 없습니다!");
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
						
						String mf = manwoman;
						// 숫자가 입력 안됐을 경우 예외처리로 idx 0으로 해줌
						int idx = 0;
						try {
							idx = Integer.parseInt(id);
						} catch (NumberFormatException r) {
							idx = 0;
							JOptionPane.showMessageDialog(MainView2.this, "ID는 필수사항이며, 숫자만 입력하세요!");
						}

						boolean flag = daoDB.update(new SaramDto(idx, name, email, phone, mf));

						if (flag) {
							JOptionPane.showMessageDialog(MainView2.this, "수정된 정보를 출력합니다!");
							displayAll();
						} else {
							JOptionPane.showMessageDialog(MainView2.this, "정보가 잘못되어 수정할 수 없습니다!");
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
						String mf = manwoman;
						
						int idx = 0;
						try {
							idx = Integer.parseInt(id);
						} catch (NumberFormatException r) {
							idx = 0;
							JOptionPane.showMessageDialog(MainView2.this, "ID는 필수사항이며, 숫자만 입력하세요!");
						}

						boolean del = daoDB.delete(new SaramDto(idx, name, email, phone, mf));

						if (del) {
							JOptionPane.showMessageDialog(MainView2.this, "삭제 되었습니다!");
							displayAll();
						} else {
							JOptionPane.showMessageDialog(MainView2.this, "삭제할 수 없습니다.");
						}

					}
				});

				finishBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(MainView2.this, "goodbye");
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
						String mf = (String) model.getValueAt(row, 4);
						txtFld1.setText(no.toString());
						txtFld2.setText(name);
						txtFld3.setText(email);
						txtFld4.setText(phone);
						
						if(mf.equals("man")) {
							rb1.setSelected(true);
						}else if(mf.equals("woman")) {
							rb2.setSelected(true);
						}
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

				rb1.addItemListener(new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent e) {
						manwoman = "man";
					}
				});

				rb2.addItemListener(new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent e) {
						manwoman = "woman";
					}
				});
				rb3.addItemListener(new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent e) {
						contentPan.remove(picturePane);
						contentPan.add(BorderLayout.CENTER,tablePane);
						repaint();
					}
				});
				
				rb4.addItemListener(new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent e) {
						
						contentPan.remove(tablePane);
						contentPan.add(BorderLayout.CENTER,picturePane);
						repaint();
					}
				});
				
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
		new MainView2().setVisible(true);
	}
}
