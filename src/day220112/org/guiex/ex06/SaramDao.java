package day220112.org.guiex.ex06;

import java.util.Vector;

public class SaramDao {
	private static Vector<SaramDto> saramList = new Vector<>();

	// 뷰에 있으면 안되니까 model로 옮김
	static {
		saramList.add(new SaramDto(1, "kim", "kim@naver.com", "010-1111-1111"));
		saramList.add(new SaramDto(2, "lee", "lee@naver.com", "010-2222-2222"));
		saramList.add(new SaramDto(3, "park", "park@naver.com", "010-3333-3333"));
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
		if(vector.size()==0) {
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
			return vector;
		}
		return null;
	}

	public boolean delete(SaramDto saram) {
		int idx = saramList.indexOf(saram);
		if (idx != -1) {
			Vector vector = new Vector();
			saramList.remove(idx);
			return true;
		}
		return false;
	}
}
