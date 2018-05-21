
public class Player implements Comparable<Player>{
	String name;
	int points;
	
	public Player(String name, int points){
		this.name = name;
		this.points = points;
	}

	@Override
	public int compareTo(Player arg) {
		return (arg.points - this.points);
	}
	
	public String toString(){
		return (this.name + " " + this.points);
	}
}
