import java.util.ArrayList;



public class Triangle extends Jewel {
	
	public Triangle(int x, int y){
		super("T", 15, new Coordinate(x,y));
		
		//match vertical jewels only
		this.jewelMatch = new VerticalMatch();
		addMatchingJewelNames(this.name);
	}

	@Override
	public ArrayList<Coordinate> findMatch(Jewel[][] gameGrid) {
		return jewelMatch.findMatch(this, gameGrid);
	}

}
