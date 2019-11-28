package games.cubeDungeon.CubePackage;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Layer {

	private ArrayList<Face> faces;
	private Face top, bottom, front, left, right, back;
	private int screen_width;/*largeur de l'écran*/

	
	public Layer(int face_width, int screen_width, int screen_height, int N) {
		this.screen_width= screen_width;
		this.front = new Face(face_width, this.screen_width, screen_height, N);
		this.left = new Face(face_width, this.screen_width, screen_height, N);
		this.right = new Face(face_width, this.screen_width, screen_height, N);
		this.back = new Face(face_width, this.screen_width, screen_height, N);
		this.top = new Face(face_width, this.screen_width, screen_height, N);
		this.bottom = new Face(face_width, this.screen_width, screen_height, N);
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics context) {
		front.render(container, game, context);
	}
	
	
	
	
	
	
	
	
	
	
}
