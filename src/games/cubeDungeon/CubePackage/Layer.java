package games.cubeDungeon.CubePackage;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Layer {

	private ArrayList<Face> faces;
	private Face top, bottom, front, left, right, back;
	private Face current_face;
	private Face currentLeft, currentTop, currentBottom, currentRight, currentBack;
	
	
	public Layer(int face_width, int screen_width, int screen_height, int N) {
		this.front  = new Face(face_width, screen_width, screen_height, N);
		this.left   = new Face(face_width, screen_width, screen_height, N);
		this.right  = new Face(face_width, screen_width, screen_height, N);
		this.back   = new Face(face_width, screen_width, screen_height, N);
		this.top    = new Face(face_width, screen_width, screen_height, N);
		this.bottom = new Face(face_width, screen_width, screen_height, N);
		this.current_face = this.front;
		this.currentLeft = this.left;
		this.currentRight = this.right;
		this.currentTop = this.top;
		this.currentBottom = this.bottom;
		this.currentBack = this.back;
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics context) {
		current_face.render(container, game, context);
	}
	
	public void rotate(int i) {
		//i=1 rotation droite, i=2 rotation gauche, i=3 rotation haut, i=4 rotation bas
		Face tempoStock = this.current_face;
		if (i==1) {
			this.current_face=this.currentRight;
			this.currentRight=this.currentBack;
			this.currentBack=this.currentLeft;
			this.currentLeft=tempoStock;
		}else if(i==2) {
			this.current_face=this.currentLeft;
			this.currentLeft=this.currentBack;
			this.currentBack=this.currentRight;
			this.currentRight=tempoStock;
		}else if(i==3) {
			this.current_face=this.currentTop;
			this.currentTop=this.currentBack;
			this.currentBack=this.currentBottom;
			this.currentBottom=tempoStock;
		}else if(i==4) {
			this.current_face=this.currentBottom;
			this.currentBottom=this.currentBack;
			this.currentBack=this.currentTop;
			this.currentTop=tempoStock;
		}
	}
	

	public Face getLeftFace() {
		return currentLeft;
	}
	
	public Face getRightFace() {
		return currentRight;
	}	
	
	public Face getTopFace() {
		return currentTop;
	}
	public Face getBottomFace() {
		return currentBottom;
	}
	public Face getCurrentFace() {
		return current_face;
	}
	
	public Face getBack() {
		return currentBack;
	}
	
}
