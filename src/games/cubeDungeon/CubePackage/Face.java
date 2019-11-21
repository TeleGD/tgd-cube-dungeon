package games.cubeDungeon.CubePackage;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Face {

	private Tile[][] grille;
	private int face_width;
	
	public Face(int face_width) {
		grille = new Tile[face_width][face_width];
		this.face_width = face_width;
		for (int i = 0; i < face_width; i++) {
			for (int j = 0; j < face_width; j++) {
				grille[i][j] = new Tile(i,j);
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
	
	
	
	
}
