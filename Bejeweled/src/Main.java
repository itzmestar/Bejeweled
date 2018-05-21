import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Main {

	String gridFilename;
	String leaderboard;
	Game game;
	ArrayList<Player> playerList;
	
	public Main(){
		
		this.game = new Game();
		
		this.leaderboard="leaderboard.txt";
		this.playerList = new ArrayList<Player>();
		
		//read player-points list
		readLeaderboard();
		
		//sort the player list based on points
		this.playerList.sort(null);
		
		//prompt user for inputs
		promptUser();
		
		//Save the leaderboard
		saveLeaderboard();
	}
	
	public static void main(String[] args) {
		Main m = new Main();
	}
	
	//read player-points file
	private void readLeaderboard(){
		try {
			Scanner scan = new Scanner(new File(this.leaderboard));
			String curLine = null;
			while(scan.hasNext()){
				curLine = scan.nextLine();
				String[] values = curLine.split(" ");
				String name = values[0].trim();
				int points = Integer.parseInt(values[1].trim());
				
				Player p = new Player(name, points);
				this.playerList.add(p);
			}
		}
		catch (FileNotFoundException e) {
		}
	}
	
	//save the updated player-point list
	private void saveLeaderboard(){
	    //To write the file
	    FileWriter fileWriter=null;
		try {
			fileWriter = new FileWriter(this.leaderboard);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			//Sort the list by points
			this.playerList.sort(null);
			
			for (Player p: this.playerList){
				printWriter.println(p);
			}
			printWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}		
	}
	
	//Find the current rank
	private int findRank(Player player){
		
		//comparator using points for Player to binary search
		Comparator<Player> c = new Comparator<Player>()
		        {
		            public int compare(Player u1, Player u2)
		            {
		                return u1.compareTo(u2);
		            }
		        };
		
		//search by points
		int index = Collections.binarySearch(playerList, player, c);
		return index;
	}
	
	public void promptUser(){
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("Select coordinate or enter E to end the game: ");
			String selected_coord = scanner.nextLine();
			if (selected_coord.equals("E")){
				break;
			}
			//split values
			String[] coords = selected_coord.split(" ");
			if(coords.length < 2){
				continue;
			}
			int x = Integer.parseInt(coords[0].trim());
			int y = Integer.parseInt(coords[1].trim());
			game.handleSelection(x, y);
		}
		System.out.println("\nTotal Score: "+game.getScore()+" points.");
		
		System.out.print("\nEnter name: ");
		String name = scanner.nextLine();
		
		Player player = new Player(name, game.getScore());
		//add player to player list
		playerList.add(player);
		int rank=findRank(player)+1;
		int size = playerList.size();
		System.out.print("Your rank is "+rank+"/"+size);
		if(rank < size && rank == 1){
			Player p1 = playerList.get(rank);
			System.out.print(", your score is "+(player.points - p1.points)+" points higher than "+p1.name);
		}else if(rank < size && rank != 1){
			Player p1 = playerList.get(rank);
			Player p2 = playerList.get(rank-2);
			System.out.print(", your score is "+(player.points - p1.points)+" points higher than "+p1.name+" and "
					+(p2.points - player.points)+" points lower than "+p2.name);
		}else if(rank == size && rank != 1){
			Player p1 = playerList.get(rank-2);
			System.out.print(", your score is "+(p1.points - player.points)+" points lower than "+p1.name);
		}
		System.out.print("\n\nGood bye!");
		

	}
}
