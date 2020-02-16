package games.cubeDungeon.CubePackage;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
//import java.lang.Math.*;
import org.newdawn.slick.Image;

public class Tile {

	int line, column; // positions dans la grille
	int screen_w, screen_h; // position pour l'affichage
	int NumByCol;
	int tile_size;
	TypeSol tile_type;
	Image texture;
	int digging; //le niveau 0 veut dire creusé, les autres correspondent à diff types de sols (à def)
	
	// Définit les différents types de sol existants.
	public enum TypeSol {
		terre, terreCreusee, roche, rocheCreusee, sable, sableCreuse;
	}

	public Tile(int line, int column, int screen_width, int screen_height, int face_width, int N) {
		this.tile_size = Math.min(screen_height,screen_width)/(N+2);
		this.screen_h = screen_height;
		this.screen_w = screen_width;
		this.NumByCol = N;
		this.line = line;
		this.column = column;
		this.changeType(TypeSol.terre);
		this.digging = 1;
	}

	// Change le type de sol de la case.
	public void changeType(TypeSol newType) {
		this.tile_type = newType;
		try {
			switch(this.tile_type) {
				case terre :
					this.texture = new Image("/res/images/soil.png");
					this.digging = 1;
					break;
				case terreCreusee :
					this.texture = new Image("/res/images/brokensoil.png");
					this.digging = 0;
					break;
				case roche :
					this.texture = new Image("/res/images/stone.png");
					this.digging = 2;
					break;
				case rocheCreusee :
					this.texture = new Image("/res/images/brokenstone.png");
					this.digging = 0;
					break;
				case sable :
					this.texture = new Image("/res/images/sand.png");
					this.digging = 3;
					break;
				case sableCreuse :
					this.texture = new Image("/res/images/brokensand.png");
					this.digging = 0;
					break;
			}
		} catch(Exception e) {e.printStackTrace();}
	}

	public void render(GameContainer container, StateBasedGame game, Graphics context) {
		context.setColor(Color.white);
		this.texture.draw(getScreenPosX(), getScreenPosY(), this.tile_size, this.tile_size);
	}

	public int getScreenPosX() {
		return ((tile_size)*column+screen_w/2-(tile_size)*(NumByCol/2));
	}

	public int getScreenPosY() {
		return (screen_h-((tile_size)*line+screen_h/2-(tile_size)*(NumByCol/2)+tile_size));
	}

	public int getDigging() {return(this.digging);}

}
