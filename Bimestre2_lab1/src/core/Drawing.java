package core;

import java.util.ArrayList;

public class Drawing  implements Shape {
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	public void add(Shape shape) {
		this.shapes.add(shape);
	}
	
	public void clear() {
		this.shapes = new ArrayList<Shape>();
		System.out.println("Clearing all the shapes from drawing");
	}
	
	@Override
	public void draw(String fillColor) {
		for (Shape shape : this.shapes) {
			shape.draw(fillColor);
		}
	}
}
