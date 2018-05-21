import java.util.ArrayList;


public class Wildcard extends Jewel {

	public Wildcard(int x, int y){
		super("W", 10, new Coordinate(x,y));
		this.jewelMatch = new RightDiagonalMatch(new LeftDiagonalMatch(new HorizontalMatch(new VerticalMatch())));
		
		//match any other jewel
		addMatchingJewelNames(this.name);
		addMatchingJewelNames("D");
		addMatchingJewelNames("T");
		addMatchingJewelNames("S");
		addMatchingJewelNames("/");
		addMatchingJewelNames("|");
		addMatchingJewelNames("-");
		addMatchingJewelNames("+");
		addMatchingJewelNames("\\");
	}

	@Override
	public ArrayList<Coordinate> findMatch(Jewel[][] gameGrid) {
		return jewelMatch.findMatch(this, gameGrid);
	}
}
