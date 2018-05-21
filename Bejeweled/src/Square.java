import java.util.ArrayList;


public class Square extends Jewel {
	
	public Square(int x, int y){
		super("S", 15, new Coordinate(x,y));
		//match horizontal jewels only
		this.jewelMatch = new HorizontalMatch();
		addMatchingJewelNames(this.name);
	}

	@Override
	public ArrayList<Coordinate> findMatch(Jewel[][] gameGrid) {
		return jewelMatch.findMatch(this, gameGrid);
	}

}
