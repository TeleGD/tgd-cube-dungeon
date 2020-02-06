package games.cubeDungeon.CubePackage;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import java.lang.Math.*;
import org.newdawn.slick.Image;

public class Tile {
	
	int line, column; // positions dans la grille
	int screen_w, screen_h; // position pour l'affichage
	int NumByCol;
	int tile_size;
	
	Image texture; 

	
	public Tile(int line, int column, int screen_width, int screen_height, int face_width, int N) {
		this.tile_size = Math.min(screen_height,screen_width)/(N+2);
		this.screen_h = screen_height;
		this.screen_w = screen_width;
		this.NumByCol = N;
		this.line = line;
		this.column = column;
		double choix = Math.random();
		double broke = Math.random();
		try {
		if(choix<0.15) {
			if (broke<0.07) {
			this.texture = new Image("/res/images/brokensoil.png");
			}else {	this.texture = new Image("/res/images/soil.png");}
		}else if(choix<0.3){
			if (broke<0.3) {
				this.texture = new Image("/res/images/brokensand.png");
				}else {	this.texture = new Image("/res/images/sand.png");}
				
		}else{
			if (broke<0.4) {
				this.texture = new Image("/res/images/brokenstone.png");
				}else {	this.texture = new Image("/res/images/stone.png");}
		}
		}catch(Exception e) {e.printStackTrace();}
	}
	
	
	public void render(GameContainer container, StateBasedGame game, Graphics context) {
		context.setColor(Color.white);
		texture.draw(getScreenPosX(),getScreenPosY(), this.tile_size,this.tile_size);
	}
	
	public int getScreenPosX() {
		return ((tile_size)*column+screen_w/2-(tile_size)*(NumByCol/2));
	}
	
	public int getScreenPosY() {
		return (screen_h-((tile_size)*line+screen_h/2-(tile_size)*(NumByCol/2)+tile_size));
	}
	

}
