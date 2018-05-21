import java.util.ArrayList;


public class Pipe extends Jewel{

	public Pipe(int x, int y){
		super("|", 20, new Coordinate(x,y));
		this.jewelMatch = new VerticalMatch();
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
