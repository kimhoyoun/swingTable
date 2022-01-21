package day220112.org.guiex.ex06.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Vector;

public class SaramDto implements Externalizable{
	private int idx;
	private String name;
	private String email;
	private String phone;
	private String gender;
	
	public SaramDto() {
		this(0,"","","", "");
	}
	
	public SaramDto(int idx, String name, String email, String phone, String gender) {
		this.idx = idx;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idx;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaramDto other = (SaramDto) obj;
		if (idx != other.idx)
			return false;
		return true;
	}
	
	public Vector toVector() {
		Vector vector = new Vector();
		vector.add(idx);
		vector.add(name);
		vector.add(email);
		vector.add(phone);
		vector.add(gender);
		
		return vector;
	}
	@Override
	public String toString() {
		return "[ "+idx + "\t" + name + "\t" + email + "\t" + phone+ "\t" + gender+" ]";
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.write(idx);
		out.writeUTF(name);
		out.writeUTF(email);
		out.writeUTF(phone);
		out.writeUTF(gender);
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		idx = in.read();
		name = in.readUTF();
		email = in.readUTF();
		phone = in.readUTF();
		gender = in.readUTF();
	}
	
	
	
}
