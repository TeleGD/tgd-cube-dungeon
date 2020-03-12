package games.cubeDungeon.CubePackage;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Image;
import games.cubeDungeon.World;
import games.cubeDungeon.CubePackage.Tile.TypeSol;

public class Player {

	private World world;
	private int width;
	private int height;
	private boolean rightPress;
	private boolean downPress;
	private boolean leftPress;
	private boolean upPress;
	private Image joueurVisu;
	private Layer layer;
	private Face face;
	private int column;
	private int line;
	private int maxMove;
	private int nivMinage;

	public Player(int Ncase,int sWidth, int sHeight, World world, Face currentFace, Layer currentLayer) {
		int taille =  Math.min(sHeight, sWidth)/(Ncase+2);
		this.face = currentFace;
		this.layer=currentLayer;
		this.width = taille;
		this.height = taille;
		this.column = 0;
		this.line = 0;
		this.maxMove = this.face.getSize();
		this.world=world;
		this.nivMinage=2;
		try {
			this.joueurVisu = new Image("/res/images/PurpleDwarfR.png");
			}catch(Exception e) {e.printStackTrace();}
		
	}

	public void update(GameContainer container, StateBasedGame game, int delta) {
		//traitement du right
		if (this.rightPress && column<maxMove-1 && this.face.getTile(line, column+1).getDigging()==0) {
			this.column += 1;
			try {
				this.joueurVisu = new Image("/res/images/PurpleDwarfR.png");
				}catch(Exception e) {e.printStackTrace();}
			
		}else if (this.rightPress && column<maxMove-1 && this.face.getTile(line, column+1).getDigging()<=this.nivMinage) {
			this.face.changeType(this.face.getTile(line, column+1), TypeSol.terreCreusee);
			try {
				this.joueurVisu = new Image("/res/images/PurpleDwarfR.png");
				}catch(Exception e) {e.printStackTrace();}
			//rotation droite
		}else if (this.rightPress && column==maxMove-1 ) {
			this.column=0;
			this.layer.rotate(1);
			this.face=this.layer.getCurrentFace();
			try {
				this.joueurVisu = new Image("/res/images/PurpleDwarfR.png");
				}catch(Exception e) {e.printStackTrace();}
			
		//traitement du left
		}else if (this.leftPress && column>0 && this.face.getTile(line, column-1).getDigging()==0) {
			this.column += -1;
			try {
				this.joueurVisu = new Image("/res/images/PurpleDwarfL.png");
				}catch(Exception e) {e.printStackTrace();}
			
		}else if (this.leftPress && column>0 && this.face.getTile(line, column-1).getDigging()<=this.nivMinage) {
			this.face.changeType(this.face.getTile(line, column-1), TypeSol.terreCreusee);
			try {
				this.joueurVisu = new Image("/res/images/PurpleDwarfL.png");
				}catch(Exception e) {e.printStackTrace();}
			
			//rotation gauche
		}else if (this.leftPress && column==0 ) {
			this.column=maxMove-1;
			this.layer.rotate(2);
			this.face=this.layer.getCurrentFace();
			try {
				this.joueurVisu = new Image("/res/images/PurpleDwarfL.png");
				}catch(Exception e) {e.printStackTrace();}
			
		//traitement du up
		}if (this.upPress && line<maxMove-1 && this.face.getTile(line+1, column).getDigging()==0) {
			this.line += 1;
			try {
				this.joueurVisu = new Image("/res/images/PurpleDwarfB.png");
				}catch(Exception e) {e.printStackTrace();}
		}else if (this.upPress && line<maxMove-1 && this.face.getTile(line+1, column).getDigging()<=this.nivMinage) {
			this.face.changeType(this.face.getTile(line+1, column), TypeSol.terreCreusee);
			try {
				this.joueurVisu = new Image("/res/images/PurpleDwarfB.png");
				}catch(Exception e) {e.printStackTrace();}
		//rotation haut
		}else if (this.upPress && line==maxMove-1) {
			this.line=0;
			this.layer.rotate(3);
			this.face=this.layer.getCurrentFace();
			try {
				this.joueurVisu = new Image("/res/images/PurpleDwarfB.png");
				}catch(Exception e) {e.printStackTrace();}
		//traitement du down
		}if (this.downPress && line>0 && this.face.getTile(line-1, column).getDigging()==0) {
			this.line += -1;
			try {
				this.joueurVisu = new Image("/res/images/PurpleDwarfF.png");
				}catch(Exception e) {e.printStackTrace();}
		}else if (this.downPress && line>0 && this.face.getTile(line-1, column).getDigging()<=this.nivMinage) {
			this.face.changeType(this.face.getTile(line-1, column), TypeSol.terreCreusee);
			try {
				this.joueurVisu = new Image("/res/images/PurpleDwarfF.png");
				}catch(Exception e) {e.printStackTrace();}
		//rotation bas
		}else if (this.downPress && line==0) {
			this.line=maxMove-1;
			this.layer.rotate(4);
			this.face=this.layer.getCurrentFace();
			try {
				this.joueurVisu = new Image("/res/images/PurpleDwarfF.png");
				}catch(Exception e) {e.printStackTrace();}
		}
		//this.x = this.face.getTile(line, column).getX();
		//this.y = this.face.getTile(line, column).getY();
		this.upPress = false;
		this.leftPress = false;
		this.rightPress = false;
		this.downPress =false;
	}

	public void render(GameContainer container, StateBasedGame game, Graphics context) {
		// Affichage du joueur
		joueurVisu.draw(this.face.getTile(line, column).getScreenPosX() , this.face.getTile(line, column).getScreenPosY(), this.width, this.height);
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

	/*public void setX(int x) {
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

	*/
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