import java.util.ArrayList;


public class Diamond extends Jewel {
	
	public Diamond(int x, int y){
		super("D", 30, new Coordinate(x,y));
		this.jewelMatch = new RightDiagonalMatch(new LeftDiagonalMatch());
		addMatchingJewelNames(this.name);
	}

	@Override
	public ArrayList<Coordinate> findMatch(Jewel[][] gameGrid) {
		return jewelMatch.findMatch(this, gameGrid);
	}

}
