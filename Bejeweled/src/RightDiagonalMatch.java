import java.util.ArrayList;


public class RightDiagonalMatch extends JewelMatchDecorator{
	public RightDiagonalMatch(){
		super(null);
	}
	
	public RightDiagonalMatch(JewelMatch jewelMatch){
		super(jewelMatch);
	}

	@Override
	public ArrayList<Coordinate> findMatch(Jewel jewelOrigin, Jewel[][] gameGrid) {
		
		ArrayList<Coordinate> list;
		
		if (jewelMatch != null){
			list =  jewelMatch.findMatch(jewelOrigin, gameGrid);
			if (list != null)
				return list;
		}
		
		list=new ArrayList<Coordinate>();
		int colSize = gameGrid.length;
		int rowSize = gameGrid[0].length;
		
		Jewel matchJewel = jewelOrigin;
		list.add(jewelOrigin.getCoordinates());
		// match first towards up right diagonal direction
		for(int j=1;j<3;j++){
			int x = jewelOrigin.getCoordinates().getX() - j;
			int y = jewelOrigin.getCoordinates().getY() + j;
			if(x > -1 && y < rowSize){
				Jewel jewel=gameGrid[x][y];
				if(matchJewel.matchJewelNames(jewel.getName())){
					Coordinate coords= new Coordinate(x, y);
					list.add(coords);
					matchJewel = jewel;
				}else{
					list.clear();
					break;
				}
			}else{
				list.clear();
				break;
			}
		}
		if(list.size()==3){
			return list;
		}
		list.add(jewelOrigin.getCoordinates());
		matchJewel = jewelOrigin;
		//match downwards right diagonal direction
		for(int j=1;j<3;j++){
			int x = jewelOrigin.getCoordinates().getX() + j;
			int y = jewelOrigin.getCoordinates().getY() - j;
			if(x < colSize && y > -1){
				Jewel jewel=gameGrid[x][y];
				if(matchJewel.matchJewelNames(jewel.getName())){
					Coordinate coords= new Coordinate(x, y);
					list.add(coords);
					matchJewel = jewel;
				}else{
					list.clear();
					return null;
				}
			}else{
				list.clear();
				return null;
			}
		}
		if(list.size()==3){
			return list;
		}
		return null;
	}


}
