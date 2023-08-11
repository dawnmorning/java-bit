package chapter04;

import java.util.Objects;

import javax.print.attribute.standard.MediaSize.Other;

public class Rect {
	private int width;
	private int height;
	
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
//	@Override
//	public int hashCode() {
//		return Objects.hash(height, width);
//	} // 같은 내용 주소 같에 만들어 버림
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Rect other = (Rect) obj;
//		return height == other.height && width == other.width;
//	}
	@Override
	public int hashCode() {
		return Objects.hash(height*width);
	} // 같은 내용 주소 같게 만들어 버림, 주소같고, 조건 검사 값이 같으면 생성 x

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rect other = (Rect) obj;
		return height * width == other.width*other.height;
	}

	@Override
	public String toString() {
		return "Rect [width=" + width + ", height = " + height + "]";
	}
}
