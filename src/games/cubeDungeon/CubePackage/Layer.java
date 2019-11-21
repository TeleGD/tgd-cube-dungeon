package games.cubeDungeon.CubePackage;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Layer {

	private ArrayList<Face> faces;
	private Face top, bottom, front, left, right, back;
	
	public Layer(int face_width) {
		this.front = new Face(face_width);
		this.left = new Face(face_width);
		this.right = new Face(face_width);
		this.back = new Face(face_width);
		this.top = new Face(face_width);
		this.bottom = new Face(face_width);
		
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics context) {
		front.render(container, game, context);
	}
	
	
	
	
	
	
	
	
	
	
}
