import javax.swing.JButton;

public class Cell extends JButton {
	
	private JButton button;
	private int id;
	private boolean isFlagged, isRevealed;
	
	public Cell(JButton button, int id, boolean isFlagged, boolean isRevealed) {
		this.button = button;
		this.id = id;
		this.isFlagged = isFlagged;
		this.isRevealed = isRevealed;
		
	}
	
	public int getCellID() {	
		return id;
	}
	
	public boolean buttonIsFlagged() {
		return isFlagged;
	}
	
	public void setIsFlagged(boolean status) {
		isFlagged = status;
	}

	public JButton getButton() {
		return button;
	}
	
	public void setRevealed() {
		isRevealed = true;
	}
	
	public boolean getRevealed() {
		return isRevealed;
	}
	
}
