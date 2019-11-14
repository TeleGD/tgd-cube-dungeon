package games.cubeDungeon.CubePackage;

public class Tile {
	
	int line, column; // positions dans la grille
	int x, y; // position pour l'affichage
	int tile_size;
	
	public Tile(int line, int column) {
		this.tile_size = 10;
		this.x = 0;
		this.y = 0;
		this.line = line;
		this.column = column;
	}
	
	

}
