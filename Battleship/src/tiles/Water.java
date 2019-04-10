package tiles;

public class Water extends AbstractTile {

	public Water() {
		rep = 0;
		AICanHit = true;
	}
	

	@Override
	public boolean hit() {
		
		//if tile is hull, then return true (hit == true)
		boolean hit = false; // false == miss, true == hit
		
		
		
		//Handle what happens when hit happens for tile in question here:
		
		
		
		//Then return
		return hit;
	}
}
