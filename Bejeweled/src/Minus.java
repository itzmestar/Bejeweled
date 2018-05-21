import java.util.ArrayList;


public class Minus extends Jewel{

	public Minus(int x, int y){
		super("-", 20, new Coordinate(x,y));
		this.jewelMatch = new HorizontalMatch();
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
