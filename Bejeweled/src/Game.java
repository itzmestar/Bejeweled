import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Game {

	Jewel[][] gameGrid;
	private int score;
	private int gridRow;
	private int gridCol;
	private String gridFilename = "gameGrid.txt";;
	
	public Game(){
		loadGameGridFromFile();
		System.out.println("Game grid:");
		printGameGrid();
	}
	
	public Game(int row, int col){
		this.gridRow = row;
		this.gridCol = col;
		this.gameGrid = new Jewel[row][col];
	}
	
	//set the jewel at x, y coord
	public void setJewel(int x, int y, Jewel j){
		this.gameGrid[x][y] = j;
	}

	//set the jewel at Coordinate coord
	public void setJewel(Coordinate coord, Jewel j){
		this.gameGrid[coord.getX()][coord.getY()] = j;
	}
	
	//return the jewel at x,y coord
	public Jewel getJewel(int x, int y){
		return this.gameGrid[x][y];
	}

	//return the jewel at Coordinate coord
	public Jewel getJewel(Coordinate coord){
		return this.gameGrid[coord.getX()][coord.getY()];
	}
	
	public void printGameGrid(){
		System.out.println();
		for (int i = 0; i < this.gridRow; i++) {
			//System.out.println();
			for (int j = 0; j < this.gridCol; j++) {
				System.out.print(this.gameGrid[i][j].getName()+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public int getScore(){
		return this.score;
	}
	
	public void handleSelection(int x, int y){
		Jewel jewel = getJewel(x, y);
		ArrayList<Coordinate> coordsList=jewel.findMatch(gameGrid);
		if(coordsList!=null){
			
			int points = applyMatch(coordsList);
			score += points;
			applyGravity(coordsList);
			printGameGrid();
			System.out.println("Score: "+points+" points.");
		}else{
			System.out.println("Warning: no match found.");
		}
	}
	
	//validate coordinates 
	//return false -> invalid coordinates
	//return true -> valid coordinates
	public boolean validCoordinates(int x, int y){
		if(x<0 || x> this.gridRow){
			return false;
		}
		if(y < 0 || y>this.gridCol){
			return false;
		}
		return true;
	}
	
	public int applyMatch(ArrayList<Coordinate> list){
		int points=0;
		for(Coordinate coords: list){
			Jewel jewel=getJewel(coords);
			points += jewel.getPoints();
			
			//Set empty jewel at the coordinate
			Jewel empty = new Empty(coords);
			setJewel(coords, empty);
		}
		
		return points;
	}
	
	public void applyGravity(ArrayList<Coordinate> list){
		for(Coordinate coords: list){
			int row=coords.getX();
			int col=coords.getY();
			for(int i=row;i>0;i--){
				Jewel empty = getJewel(i,col);
				Jewel target = getJewel(i-1,col);
				setJewel(i-1,col,empty);
				empty.setCoordinates(i-1, col);
				setJewel(i,col,target);
				target.setCoordinates(i, col);
			}
		}
	}
	
	private void loadGameGridFromFile(){
		try {
			Scanner scan = new Scanner(new File(this.gridFilename));
			String curLine = null;
			
		    //count number of lines
		    while(scan.hasNext()){
		    	curLine = scan.nextLine();	
		    	this.gridRow++;
		    }
		    
		    //count number of columns
		    String[] cols = curLine.split(" ");
		    this.gridCol = cols.length;
		    
		    //close scanner
		    scan.close();
		    
		    //define the array
		    this.gameGrid = new Jewel[this.gridRow][this.gridCol];
		    
		    scan = new Scanner(new File(this.gridFilename));
		    int i=0;
		    Jewel jewel = null;
		    while(scan.hasNext()){
		    	//read line
		        curLine = scan.nextLine();
		        
		        //get space separated values
		        String[] values = curLine.split(" ");
		        for(int j=0;j<values.length;j++){
		        	String jewelName =  values[j].trim();
		        	if (jewelName.equals("D")){
		        		jewel = new Diamond(i,j);
		        	}else if (jewelName.equals("S")){
		        		jewel = new Square(i,j);
		        	}else if (jewelName.equals("T")){
		        		jewel = new Triangle(i,j);
		        	}else if (jewelName.equals("W")){
		        		jewel = new Wildcard(i,j);
		        	}else if (jewelName.equals("+")){
		        		jewel = new Plus(i,j);
		        	}else if (jewelName.equals("-")){
		        		jewel = new Minus(i,j);
		        	}else if (jewelName.equals("/")){
		        		jewel = new Slash(i,j);
		        	}else if (jewelName.equals("\\")){
		        		jewel = new Backslash(i,j);
		        	}else if (jewelName.equals("|")){
		        		jewel = new Pipe(i,j);
		        	}
		        	else{
		        		jewel = new Empty(new Coordinate(i,j));
		        	}
		        	
		        	//assign to grid
		        	this.gameGrid[i][j] = jewel;
		        }
		        i++;
		    }
		} catch (FileNotFoundException e) {
			
		}
	}
}
