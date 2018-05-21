import java.util.ArrayList;


public class Slash extends Jewel{

	public Slash(int x, int y){
		super("/", 20, new Coordinate(x,y));
		this.jewelMatch = new RightDiagonalMatch();
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
