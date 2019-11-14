package games.cubeDungeon.CubePackage;

import java.util.ArrayList;

public class Line {

	private ArrayList<Tile> tiles;
	
	public Line(int width, int line_number) {
		tiles = new ArrayList<Tile>();
		
		for (int i = 0; i < width; i++) {
			
			tiles.add(new Tile(line_number, i));
		}
	}
	
	
	
}
