package games.cubeDungeon;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import games.cubeDungeon.CubePackage.*;

import games.cubeDungeon.CubePackage.Tile;


public class World extends BasicGameState {

	private int ID;
	private int state;
	private Cube cube;
	private int screen_width;/*largeur de l'écran*/
	private int screen_height;/*hauteur de l'écran*/
	private Player Nico;

	public World(int ID) {
		this.ID = ID;
		this.state = 0;
		//empla joueur basique
	}

	@Override
	public int getID() {
		return this.ID;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée une unique fois au chargement du programme */
		this.screen_width=container.getWidth();
		this.screen_height=container.getHeight();
		this.cube = new Cube(20,screen_width,screen_height);
		this.Nico = new Player(20,screen_width,screen_height);
	}

	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée à l'apparition de la page */
		if (this.state == 0) {
			this.play(container, game);
		} else if (this.state == 2) {
			this.resume(container, game);
		}
	}

	@Override
	public void leave(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée à la disparition de la page */
		if (this.state == 1) {
			this.pause(container, game);
		} else if (this.state == 3) {
			this.stop(container, game);
			this.state = 0; // TODO: remove
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) {
		/* Méthode exécutée environ 60 fois par seconde */
		Input input = container.getInput();
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			this.setState(1);
			game.enterState(2, new FadeOutTransition(), new FadeInTransition());
		}
		Nico.update(container, game, delta);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics context) {
		/* Méthode exécutée environ 60 fois par seconde */
		cube.render(container,game,context);
		Nico.render(container, game, context);
	}

	public void play(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée une unique fois au début du jeu */
	}

	public void pause(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée lors de la mise en pause du jeu */
	}

	public void resume(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée lors de la reprise du jeu */
	}

	public void stop(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée une unique fois à la fin du jeu */
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return this.state;
	}
	public void setPlayer(Player player) {
		this.Nico = player;
	}

	public Player getPlayer() {
		return this.Nico;
	}
	public void keyPressed(int key, char c) {
		this.Nico.keyPressed(key, c);
	}

	public void keyReleased(int key, char c) {
		this.Nico.keyReleased(key, c);
	}

}
