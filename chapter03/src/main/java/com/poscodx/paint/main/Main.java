package com.poscodx.paint.main;

import com.poscodx.paint.i.Drawable;
import com.poscodx.paint.point.ColorPoint;
import com.poscodx.paint.point.Point;
import com.poscodx.paint.shape.Circle;
import com.poscodx.paint.shape.Rect;
import com.poscodx.paint.shape.Shape;
import com.poscodx.paint.shape.Triangle;
import com.poscodx.paint.text.GraphicText;

public class Main {

	public static void main(String[] args) {
		Point point1 = new Point(10, 20);
//		point1.setX(10);
//		point1.setY(20);
		
//		drawPoint(point1);
		draw(point1);
		// point1.disappear();
		point1.show(false);

//		ColorPoint point2 = new ColorPoint();
		Point point2 = new ColorPoint();
		point2.setX(20);
		point2.setY(20);
		
		// 자식 클래스를 부모클래스 속성을 가져오려면
		// 우리가 작은 범위 자료구조에서 큰 자료구조 가져올 때 () 했던 것과 같이 함
		// ColorPoint p = (ColorPoint) point2;
		
		// 강제로 우선순위 만들어 주기
		((ColorPoint)point2).setColor("red");
//		drawPoint(point2);
		draw(point2);
		
		Rect rect = new Rect();
//		drawRect(rect);
//		drawShape(rect);
		draw(rect);
		
		Triangle triangle = new Triangle();
//		drawTri(triangle);
//		drawShape(triangle);
		draw(triangle);
		
		// new Shape();
		// Cannot instantiate the type Shape
		Circle circle = new Circle();
//		drawShape(circle);
		draw(circle);
		draw(new GraphicText("Hello World"));
		
		// instanceof 연산자 Test
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		System.out.println(circle instanceof Object);
		
		// 오류: 연산자 우측항이 클래스인 경우, 레퍼펀스 하고 있는 (Circle circle) class타입의 
		// hierarchy 상의 하위와 상위만 instanceof 연산자를 사용할 수 있다.
		// interface는 hierarchy 관계가 아니라 경우가 다를 수 있음
		// System.out.println(circle instanceof Rect);
		
		// 연산자 우측항이 인터페이스인 경우,
		// Hierarchy가 없으므로.. instanceof 연산자를 사용할 수 있다.
		System.out.println(circle instanceof Drawable);
		System.out.println(circle instanceof Runnable);
	}
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
//	public static void drawPoint(Point point) {
//		point.show();
//	}

//	public static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}
	
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
	
//	public static void drawRect(Rect rect) {
//		rect.draw();
//	}
//	public static void drawTri(Triangle triangle) {
//		triangle.draw();
//	}
}
