package matrix;

import tiles.AbstractTile;
import tiles.Hull;
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
	 * create a matrix with x*y tiles of tile type "defaultTile"
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
	
	
}
