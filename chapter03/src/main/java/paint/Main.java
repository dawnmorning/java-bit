package paint;

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
