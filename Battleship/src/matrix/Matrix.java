package matrix;

import tiles.AbstractTile;
import tiles.Hit;
import tiles.Hull;
import tiles.Miss;
import tiles.Water;


/*
 * Used to save a matrix in data.
 * 
 * i will be used as a holder for "tile" information.
 * 
 * information can be changed in me, and i can be used to retrieve information.
 * 
 */


public class Matrix {
	
	
	private AbstractTile[][] matrix;
	private int x;
	private int y;
	
	/*
	 * create a matrix with x*y tiles of tile type "Water"
	 */
	public Matrix(int x, int y){
		this.x = x;
		this.y = y;
		matrix = new AbstractTile[x][y];

		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				matrix[i][j] = new Water();
			}
		}
	}
	
	
	
	public AbstractTile getTile(int x, int y) {
		return matrix[x][y];
	}
	
	/*
	 * get a matrix with only integer defining tile rep as an integer matrix
	 */
	public int[][] getAllTileReps() {
		int[][] xyMatrix = new int[x][y];
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; i++) {
				xyMatrix[i][j] = getTile(x,y).getRep();
			}
		}
		return xyMatrix;
	}

	/*
	 * use to get total amount of tiles
	 */
	public int countTiles() {
		return x*y;
	}
	
	/*
	 * use to count number of tiles of specific type
	 */
	public int countTiles(AbstractTile tile) {
		int total = 0;
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; i++) {
				total++;
			}
		}
		return total;
	}
	
	/*
	 * temporary autofill for testing porpouses
	 */
	public void putHull() {
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				if(((i+j) % 3) == 0)
				matrix[i][j] = new Hull();
			}
		}
	}
	
	/*
	 * ShipPlacementChekker. cheks if a ship can be placed where you want it to be placed.
	 * first two parameters for north-western corner
	 * 3rd for how long the ship is in tiles
	 * 4th boolean for if the ship is vertical, else horizontal.
	 */
	private boolean canPlaceShip(int x, int y, int length, boolean vertical) {
		boolean anserw = false;
		
		
		//Chek if it can fit where you want it to
		if (vertical) {
			//when vertical
			if ((this.y - y) >= length) {
				anserw = true;
			}else {
				return false;
			}
		}else {
			//when horizontal
			if ((this.x - x) >= length) {
				anserw = true;
			}else {
				return false;
			}
		}
		
		
		//Chek if it intersects only "Water"
		if (vertical) {
			//when vertical
			for (int i = 0; i < length; i++) {
				if (!(getTile(x,y+i).getRep() == 0)) {
					anserw = false;
				}
			}
		}else {
			//when horizontal
			for (int i = 0; i < length; i++) {
				if (!(getTile(x+i,y).getRep() == 0)) {
					anserw = false;
				}
			}
		}
		
		return anserw;
	}
	
	
	/*
	 * ShipPlacer
	 * Returns true if it placed the ship, false if it can't place.
	 * first two parameters for north-western corner
	 * 3rd for how long the ship is in tiles
	 * 4th boolean for if the ship is vertical, else horizontal.
	 */
	public boolean placeShip(int x, int y, int length, boolean vertical) {

		//tests if can place...
		boolean test = canPlaceShip(x,y,length,vertical);
		if (!test) {
			return false;
		}
		
		//Places ship on matrix if can place.
		if (vertical) {
			//when vertical
			for (int i = 0; i < length; i++) {
				setTile(x,y+i, new Hull());
			}
		}else {
			//when horizontal
			for (int i = 0; i < length; i++) {
				setTile(x+i,y, new Hull());
			}
		}
		
		return true;
	}
	
	
	
	
	
	
	/*
	 * IlogicalPlacer
	 */
	//TODO: ADD ME
	
	
	
	
	
	/*
	 * replaces tile on cordinate x,y to 3rd parameter (AbstractTile). make sure to make it a new object.
	 */
	private void setTile(int x, int y, AbstractTile replacement) {
		matrix[x][y] = replacement;	
	}

	/*
	 * HitEffectHandler
	 */
	private String hitEffectHandler(int x, int y){
		AbstractTile target = getTile(x,y);
		if(target.hit()) {
			setTile(x,y, new Hit());
			return "1,";
		}else {
			setTile(x,y, new Miss());
			return "0,";
		}
	}
	
	



	/*
	 * Handle hits on main board
	 */
	public String hitOrMiss(String xString, String yString) {
		String anserw = "";
		
		//parse
		int x = Integer.parseInt(xString);
		int y = Integer.parseInt(yString);
		
		AbstractTile target = this.getTile(x, y); //idk if usefull?
		
		
		//Was it a hull?
		
				anserw += hitEffectHandler(x,y);
		
		//Was there a boat that got sunk?
		
				//Handle that shit here :S AAMUJA!!!!
			
			//temporary:
				anserw += "0,";
		
		
		
		//did you just loose?
		
				if (countTiles(new Hull()) <= 0) {
					anserw += "1";
				}else {
					anserw += "0";
				}
		
		
		return anserw;
	}
	
	
}
