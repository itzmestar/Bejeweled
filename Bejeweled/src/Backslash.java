import java.util.ArrayList;


public class Backslash extends Jewel{

	public Backslash(int x, int y){
		super("\\", 20, new Coordinate(x,y));
		this.jewelMatch = new LeftDiagonalMatch();
		addMatchingJewelNames("/");
		addMatchingJewelNames("+");
		addMatchingJewelNames("-");
		addMatchingJewelNames("\\");
		addMatchingJewelNames("|");
	}

	@Override
	public ArrayList<Coordinate> findMatch(Jewel[][] gameGrid) {
		return jewelMatch.findMatch(this, gameGrid);
	}


}
