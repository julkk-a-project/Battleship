package ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import controller.Controller;
import matrix.Matrix;

public class AI {
	List<String> coords;
	List<Boolean> vertical;
	private int coordIndex;
	private Matrix myMatrix;
	private Matrix itMatrix;
	

	//For testing only
	public static void main(String[] args) {
		Controller controller = new Controller();
		AI ai = new AI(controller);
	}
	
	
	public AI(Controller controller) {
		coords = new ArrayList<>();
		vertical = new ArrayList<>();
        vertical.add(true);
        vertical.add(false);
        
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
		        coords.add(i+","+j);
			}
		}	

		shuffleCoords();
		shuffleVertical();
		
		itMatrix = new Matrix(10,10, controller);
		myMatrix = new Matrix(10,10, controller);
		
		
		
		
		
		
		
		
	}

	
	
	public void shuffleCoords() {
		Collections.shuffle(coords);
		System.out.println(coords);
		
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
			if(main.Main.myMatrix.placeShip(coords[0], coords[1], length, vertical.get(1))) {
				return;
			}	
		}
		System.out.println("AI SUCKS AT PLACING SHIPS");
	}


	private int[] getNextCoords() {
		if (coordIndex > coords.size()) {
			coordIndex = 0;
		}
		String[] SCords = coords.get(coordIndex).split(",");
		int cordX = Integer.parseInt(SCords[0]);
		int cordY = Integer.parseInt(SCords[0]);
		int[] ICords = {cordX, cordY};
		coordIndex++;
		return ICords;
		
	}

}
