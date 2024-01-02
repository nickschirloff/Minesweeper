import javax.swing.JMenuItem;

public class MSCommandMenuItem extends JMenuItem{

	private String command;
	public MSCommandMenuItem(String label) {
		super(label);
		command = label;
		
	}//End of constructor
	
	public String getCommand() {
		return command;
	}
	

	
}//End of class
