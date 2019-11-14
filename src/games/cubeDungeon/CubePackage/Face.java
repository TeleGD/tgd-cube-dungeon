package games.cubeDungeon.CubePackage;

import java.util.ArrayList;

public class Face {

	private ArrayList<Line> lines;
	
	public Face(int face_width) {
		lines = new ArrayList<Line>();
		
		for (int i = 0; i < face_width; i++) {
			
			lines.add(new Line(face_width, i));
			
		}
	}
	
	
	
	
	
	
}
