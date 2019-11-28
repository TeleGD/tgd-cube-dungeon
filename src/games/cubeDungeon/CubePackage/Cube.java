package games.cubeDungeon.CubePackage;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Cube {
	
	private Layer current_layer;
	
	public Cube(int current_layer_width, int screen_width, int screen_height) {
		current_layer = new Layer(current_layer_width, screen_width, screen_height, current_layer_width);
		}
	
	public void render(GameContainer container, StateBasedGame game, Graphics context) {
		current_layer.render(container, game, context);
	}
	
	
	
	
	
	
}
