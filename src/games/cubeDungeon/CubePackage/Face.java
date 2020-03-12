package games.cubeDungeon.CubePackage;

import java.util.ArrayList;
import java.util.Random;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import games.cubeDungeon.CubePackage.Tile.TypeSol;

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
		this.generation();
	}

	private void generation() {
		Random rand = new Random();
		for (int k = 0 ; k < this.face_width ; k++) {
			int x = rand.nextInt(this.face_width);
			int y = rand.nextInt(this.face_width);
			grille[x][y].changeType(Tile.TypeSol.roche);
		}
	}
	//double choix = Math.random();
	//double broke = Math.random();





	public void render(GameContainer container, StateBasedGame game, Graphics context) {
		for (int i = 0; i < this.face_width; i++) {
			for (int j = 0; j < this.face_width; j++) {
				grille[i][j].render(container, game, context);
			}
		}
	}
	public void changeType(Tile tile, TypeSol newType) {
		tile.changeType(newType);

	}

	public Tile getTile(int i, int j) {
		return(this.grille[i][j]);
	}

	public int getSize() {
		return face_width;
	}
}
