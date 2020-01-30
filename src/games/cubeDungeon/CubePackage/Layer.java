package games.cubeDungeon.CubePackage;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Layer {

	private ArrayList<Face> faces;
	private Face top, bottom, front, left, right, back;
	private Face current_face;
	
	public Layer(int face_width, int screen_width, int screen_height, int N) {
		this.front  = new Face(face_width, screen_width, screen_height, N);
		this.left   = new Face(face_width, screen_width, screen_height, N);
		this.right  = new Face(face_width, screen_width, screen_height, N);
		this.back   = new Face(face_width, screen_width, screen_height, N);
		this.top    = new Face(face_width, screen_width, screen_height, N);
		this.bottom = new Face(face_width, screen_width, screen_height, N);
		this.current_face = this.front;
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics context) {
		current_face.render(container, game, context);
	}
	
	public Face getActual() {
		return current_face;
	}
	
	
	
	
	
	
	
	
}
