package games.cubeDungeon.CubePackage;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Face {

	private Tile[][] grille;
	private int face_width;


	
	public Face(int face_width, int screen_width, int screen_height, int N) {
		this.face_width = face_width;
		grille = new Tile[this.face_width][this.face_width];
		for (int i = 0; i < this.face_width; i++) {
			for (int j = 0; j < this.face_width; j++) {
				grille[i][j] = new Tile(i,j, screen_width, screen_height, this.face_width, N);
			}
		}
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics context) {
		for (int i = 0; i < this.face_width; i++) {
			for (int j = 0; j < this.face_width; j++) {
				grille[i][j].render(container, game, context);
			}
		}
	}
	
	public Tile getTile(int i, int j) {
		return(this.grille[i][j]);
	}
	
	
}
