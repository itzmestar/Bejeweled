import java.util.ArrayList;


public class VerticalMatch extends JewelMatchDecorator{
	public VerticalMatch(){
		super(null);
	}
	
	public VerticalMatch(JewelMatch jewelMatch){
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
		
		int y = jewelOrigin.getCoordinates().getY();
		int x = jewelOrigin.getCoordinates().getX();
		list.add(jewelOrigin.getCoordinates());
		
		Jewel matchJewel = jewelOrigin;
		// match first towards up direction
		for(int j=1;j<3;j++){
			x -= 1;
			if(x > -1){
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
		
		//match downwards direction
		x = jewelOrigin.getCoordinates().getX();
		matchJewel = jewelOrigin;
		for(int j=1;j<3;j++){
			x += 1;
			if(x < colSize){
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
