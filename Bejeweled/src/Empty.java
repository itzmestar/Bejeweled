import java.util.ArrayList;


public class Empty extends Jewel {

	public Empty(Coordinate coordinate){
		super(" ", 0, coordinate);
		this.jewelMatch = null;
	}

	@Override
	public ArrayList<Coordinate> findMatch(Jewel[][] gameGrid) {
		return null;
	}
}
