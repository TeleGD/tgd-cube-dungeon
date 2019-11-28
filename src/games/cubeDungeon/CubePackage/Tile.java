package games.cubeDungeon.CubePackage;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import java.lang.Math.*;

public class Tile {
	
	int line, column; // positions dans la grille
	int x, y; // position pour l'affichage
	int tile_size;

	
	public Tile(int line, int column, int screen_width, int screen_height, int face_width, int N) {
		this.tile_size = Math.min(screen_height,screen_width)/(N+2);
		this.x = (tile_size+1)*line;
		this.y = (tile_size+1)*column;
		this.line = line;
		this.column = column;
	}
	public void render(GameContainer container, StateBasedGame game, Graphics context) {
		context.fillRect(this.x,this.y, this.tile_size,this.tile_size);
	}
	
}
