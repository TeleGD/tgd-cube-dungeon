package games.cubeDungeon.CubePackage;

import java.util.ArrayList;

public class Layer {

	private ArrayList<Face> faces;
	
	public Layer(int face_width) {
		
		faces = new ArrayList<Face>();
		for (int i = 0; i < 6; i++)
			faces.add(new Face(face_width));
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
