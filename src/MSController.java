import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MSController {
	
	private MSFrame frame;
	
	public MSController(MSFrame frame) {
		this.frame = frame;
	}
	
	public void performCommand(String command) {
		
		if(command == "How to Play")
		{
			frame.getView().howToPlay();
		}
		else if(command == "Show Board")
		{
			frame.getView().showBoard();
		}
		else if(command == "New Game")
		{
			String temp = frame.getView().startNewGame();
			frame.dispose();
			new MSFrame();
		}
		else if(command == "Quit")
		{
			frame.dispose();
		}
	}
	
	public void revealCell(Cell cell, JButton button) {
		
		int cellValue = frame.getModel().getValueOfCell(cell.getCellID());
		if(cellValue == -1)
		{
			frame.getView().colorCell(cell);
			button.setText("M");
			frame.getView().showBoard();
			JOptionPane.showMessageDialog(null, "Boom! You clicked on a mine! Select \"New Game\" to try again.");
		}
		else
		{
			frame.getView().colorCell(cell);
			button.setText(Integer.toString(cellValue));
		}
				
	}
	
	public void flagCell(Cell cell, JButton button) {
		cell.setIsFlagged(true);
		button.setText("F");
		button.setBackground(Color.blue);
		
	}
	
	public void unflagCell(Cell cell, JButton button) {
		cell.setIsFlagged(false);
		button.setText("?");
		button.setBackground(null);
		
	}
	
	

}
