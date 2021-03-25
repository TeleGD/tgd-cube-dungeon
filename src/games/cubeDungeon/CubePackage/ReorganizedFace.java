package games.cubeDungeon.CubePackage;

import java.util.ArrayList;

public class ReorganizedFace {

	/*
	 * Cette classe correspond à la face courante, réorganisée par rapport à la façon dont elle est affichée.
	 *
	 * La case (ligne = 0; colonne = 0) correpsond à la case en bas à gauche de l'écran,
	 * et non pas à la case "en bas à gauche" dans la face telle qu'elle a été créée.
	 *
	 */

	private ArrayList<Tile> tiles;

	public ReorganizedFace(/* ... */) {
		tiles = new ArrayList<Tile>(/* ... */);

		/*
		for (int i = 0; i < ...; i++) {

			tiles.add(...);
		}
		*/

	}


}
