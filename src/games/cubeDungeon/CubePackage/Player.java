package games.cubeDungeon.CubePackage;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Image;

public class Player {

	private int x;
	private int y;

	private int width;
	private int height;
	private boolean rightPress;
	private boolean downPress;
	private boolean leftPress;
	private boolean upPress;
	private Image joueurVisu;

	private int col;

	public Player(int Ncase,int sWidth, int sHeight) {
		int taille =  Math.min(sHeight, sWidth)/(Ncase+2);
		this.x = 2;
		this.y = 2;
		this.width = taille;
		this.height = taille;
		this.col = 0;
		try {
			this.joueurVisu = new Image("/res/images/joueurVisuFirst.gif");
		}catch(Exception e) {e.printStackTrace();}
		
	}

	public void update(GameContainer container, StateBasedGame game, int delta) {
		this.x += (this.rightPress ? 1 : (this.leftPress ? -1 : 0));
		this.y += (this.upPress ? -1 : (this.downPress ? 1 : 0));
		//solution caca en attendant le template arcade
		this.upPress = false;
		this.leftPress = false;
		this.rightPress = false;
		this.downPress =false;
	}

	public void render(GameContainer container, StateBasedGame game, Graphics context) {
		// Affichage du joueur
		joueurVisu.draw(this.x *this.width , this.y * this.height , this.width, this.height);
	}

	public void keyPressed(int key, char c) {
		// Détection des entrées de clavier (appuie sur une touche)
		switch (key) {
			case Input.KEY_UP: {
				this.upPress = true;
				break;
			}
			case Input.KEY_DOWN: {
				this.downPress = true;
				break;
			}
			case Input.KEY_LEFT: {
				this.leftPress = true;
				break;
			}
			case Input.KEY_RIGHT: {
				this.rightPress = true;
				break;
			}
		}
	}

	// Détection des entrées de clavier (relache une touche)
	public void keyReleased(int key, char c) {
		switch (key) {
			case Input.KEY_UP: {
				this.upPress = false;
				break;
			}
			case Input.KEY_DOWN: {
				this.downPress = false;
				break;
			}
			case Input.KEY_LEFT: {
				this.leftPress = false;
				break;
			}
			case Input.KEY_RIGHT: {
				this.rightPress = false;
				break;
			}
		}
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getX() {
		return this.x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getY() {
		return this.y;
	}

	
	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return this.width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return this.height;
	}

}