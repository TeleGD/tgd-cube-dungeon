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

	// Le constructeur
	// Prend quatre arguments :
	// -la largeur de la face
	// -la largeur de l'écran
	// -la hauteur de l'écran
	// -???
	public Face(int face_width, int screen_width, int screen_height, int N) {
		this.face_width = face_width;
		this.grille = new Tile[this.face_width][this.face_width];
		for (int i = 0; i < this.face_width; i++) {
			for (int j = 0; j < this.face_width; j++) {
				this.grille[i][j] = new Tile(i, j, screen_width, screen_height, this.face_width, N);
			}
		}
		this.generation();
	}

	private void generation() {
		Random r = new Random();
		int n = 3;
		// Génère n taches de sable
		for (int k = 0 ; k < n ; k++) {
			int i = r.nextInt(this.face_width);
			int j = r.nextInt(this.face_width);
			grille[i][j].changeType(Tile.TypeSol.sable);
			int c[] = {1, 0, 1, 0};
			for (int l = 0 ; l < 24 ; l++) {
				switch(c[0]) {
					case 1 :
						if (i < this.face_width-1) {
							i++;
						}
						break;
					case 2 :
						if (j < this.face_width-1) {
							j++;
						}
						break;
					case 3 :
						if (i > 1) {
							i--;
						}
						break;
					case 4 :
						if (j > 1) {
							j--;
						}
						break;
				}
				int m = r.nextInt(l+1);
				if (m < 5) {
					grille[i][j].changeType(Tile.TypeSol.sable);
				}
				c[1]++;
				if (c[1] == c[2]) {
					c[0]++;
					if (c[0] == 5) {
						c[0] = 1;
					}
					c[1]=0;
					if (c[3] == 1) {
						c[2]++;
						c[3]=0;
					} else {
						c[3]++;
					}
				}
			}
		}
		for (int k = 0 ; k < this.face_width ; k++) {
			int x = r.nextInt(this.face_width);
			int y = r.nextInt(this.face_width);
			grille[x][y].changeType(Tile.TypeSol.roche);
		}
	}
	//double autre_maniere_aleatoire = Math.random();

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
