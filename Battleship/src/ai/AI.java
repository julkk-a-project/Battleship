package ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AI {
	List<String> coords;
	List<Boolean> vertical;
	

	//For testing only
	public static void main(String[] args) {
		AI ai = new AI();
		ai.shuffleCoords();
		ai.shuffleVertical();
	}
	
	
	public AI() {
		coords = new ArrayList<>();
		vertical = new ArrayList<>();
        vertical.add(true);
        vertical.add(false);
        
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
		        coords.add(i+","+j);
			}
		}	
		
		
	}

	
	
	public void shuffleCoords() {
		Collections.shuffle(coordsX);
		Collections.shuffle(coordsY);
		System.out.println(coordsX + "\n" + coordsY);
		
	}
	
	
	
	public void shuffleVertical() {
		Collections.shuffle(vertical);
		System.out.println(vertical+"");
		
	}
	
	
	
	
	
	 
	public void shipPlacer() {
		//public boolean placeShip(int x, int y, int length, boolean vertical) 
		int[]ships = {5,4,3,3,2}; //TODO: IF WE MAKE THIS A CHANGING VARIABLE, STORE IN MODEL.
		
		for(int i = 0; i<ships.length; i++) {
			individualShipPlacer(ships[i]);
		}
		//TODO: window.Window.showNewGame();
	}
	
	private void individualShipPlacer(int length){
		int i = 0;
		while(i < 200) {
			
			int[] coords = getNextCoords();
			
			
			
			if(main.Main.myMatrix.placeShip(coords[0], coords[1], length, vertical.get(0))) {
				return;
			}		
			if(main.Main.myMatrix.placeShip(x, y, length, vertical.get(1))) {
				return;
			}	
		}
		System.out.println("AI SUCKS AT PLACING SHIPS");
	}


	private int[] getNextCoords() {
		
		return coords;
	}


	private int getNextY() {
		if (indexY == coordsY.size()) {
			indexY = 0;
		}
		int y = coordsY.get(indexY);
		indexY++;
		return y;
	}


	private int getNextX() {
		if (indexX == coordsX.size()) {
			indexX = 0;
		}
		int x = coordsX.get(indexX);
		indexX++;
		return x;
	}

}
