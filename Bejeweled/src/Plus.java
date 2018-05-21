import java.util.ArrayList;


public class Plus extends Jewel{

	public Plus(int x, int y){
		super("+", 20, new Coordinate(x,y));
		
		//match horizontal then vertical jewels
		this.jewelMatch = new VerticalMatch(new HorizontalMatch());
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
