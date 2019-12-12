package games.cubeDungeon.CubePackage;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import java.lang.Math.*;
import org.newdawn.slick.Image;

public class Tile {
	
	int line, column; // positions dans la grille
	int x, y; // position pour l'affichage
	int tile_size;
	Image texture; 

	
	public Tile(int line, int column, int screen_width, int screen_height, int face_width, int N) {
		this.tile_size = Math.min(screen_height,screen_width)/(N+2);
		this.x = (tile_size)*line+screen_width/2-(tile_size)*(N/2);
		this.y = (tile_size)*column+screen_height/2-(tile_size)*(N/2);
		this.line = line;
		this.column = column;
		try {
		this.texture = new Image("/res/images/blocktest.png");
		}catch(Exception e) {e.printStackTrace();}
	}
	public void render(GameContainer container, StateBasedGame game, Graphics context) {
		context.setColor(Color.white);
		texture.draw(this.x,this.y, this.tile_size,this.tile_size);
	}
	
}
