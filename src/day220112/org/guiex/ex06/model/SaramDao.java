package day220112.org.guiex.ex06.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class SaramDao {
	private static Vector<SaramDto> saramList = new Vector<>();
	private static File file = new File("tableData.dat");
	private FileOutputStream fos;
	private FileInputStream fis;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	// 뷰에 있으면 안되니까 model로 옮김
	static {
		saramList.add(new SaramDto(1, "kim", "kim@naver.com", "010-1111-1111","man"));
		saramList.add(new SaramDto(2, "lee", "lee@naver.com", "010-2222-2222","woman"));
		saramList.add(new SaramDto(3, "park", "park@naver.com", "010-3333-3333","man"));
	}
	{
		read();
		sequence = setSeq();
	}
	public static int sequence = 4;

	// 벡터안에 벡터가 있는걸 만들어줌
	// 뷰에서 벡터안에 데이터 타입이 무엇인지 모르기때문에 데이터를 vector로 바꿔서 넘겨준다.
	public Vector selectAll() {
		Vector vector = new Vector();
		for (int i = 0; i < saramList.size(); i++) {
			vector.add(saramList.get(i).toVector());
		}

		return vector;
	}

	public boolean insert(SaramDto saramDto) {
		if (!((saramDto.getName().equals("")) || (saramDto.getEmail().equals(""))
				|| (saramDto.getPhone().equals("")))) {
			saramDto.setIdx(sequence++);
			saramList.add(saramDto);
			save();
			return true;
		}
		return false;
	}

	public Vector search(SaramDto saram) {
		Vector vector = new Vector();
		for (int i = 0; i < saramList.size(); i++) {
			if (saram.getName().equals(saramList.get(i).getName())) {
				vector.add(saramList.get(i).toVector());
			}
		}
		if (vector.size() == 0) {
			return null;
		}
		return vector;
	}

	public Vector modify(SaramDto saram) {
		int idx = saramList.indexOf(saram);
		Vector vector = new Vector();
		if (idx != -1) {
			saramList.set(idx, saram);
			vector = saramList.get(idx).toVector();
			save();
			return vector;
		}
		return null;
	}

	public boolean delete(SaramDto saram) {
		int idx = saramList.indexOf(saram);
		if (idx != -1) {
			Vector vector = new Vector();
			saramList.remove(idx);
			save();
			return true;
		}
		return false;
	}

	public void save() {

		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(saramList);
		} catch (FileNotFoundException e) {
		} catch (SecurityException e) {
		} catch (IOException e) {
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
			}
		}
	}

	public void read() {
		if (file.exists()) {

			try {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				saramList = (Vector<SaramDto>) ois.readObject();

			} catch (FileNotFoundException e) {
			} catch (ClassNotFoundException e) {
			} catch (IOException e) {
			} finally {
				try {
					ois.close();
				} catch (IOException e) {
				}
			}
		}

	}

	public int setSeq() {
		int num = 4;
		if (file.exists()) {
			num = saramList.size() + 1;
		}
		return num;
	}
}
