import java.util.ArrayList;


public abstract class JewelMatchDecorator implements JewelMatch{

	protected JewelMatch jewelMatch;
	
	public JewelMatchDecorator(JewelMatch jewelMatch){
		this.jewelMatch = jewelMatch;
	}
}
