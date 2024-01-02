import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MSView extends JPanel {

	private MSFrame frame;
	JPanel labelPanel, mainPanel;
	private ArrayList<Cell> cellList = new ArrayList<>();
	private JLabel mineLabel;
	
	public MSView(MSFrame frame) {
		this.frame = frame;
		
		labelPanel = new JPanel();
		labelPanel.setBounds(0,0,500,50);
		labelPanel.setLayout(new FlowLayout());
		mineLabel = new JLabel();
		mineLabel.setText("Mines Remaining: " + frame.getModel().getNumMines());
		labelPanel.add(mineLabel);
		add(labelPanel);

		mainPanel = new JPanel();
		mainPanel.setBounds(0,50,500,600);
		mainPanel.setLayout(new GridLayout(0,10));
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		populateView(mainPanel);
		add(mainPanel);
	}
	
	public void populateView(JPanel panel) {
		
		for(int i = 0; i < 100; i++)
		{
			JButton button = new JButton("?");
			button.setPreferredSize(new Dimension(47, 59));
			Cell cell = new Cell(button, i, false, false);
			button.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					//If button is left clicked
					if(e.getButton() == MouseEvent.BUTTON1)
					{
						//If the button is not flagged, show the button
						if(!cell.buttonIsFlagged())
						{
							frame.getController().revealCell(cell, button);
						}
						else
						{
							//Do nothing
						}
					}
					else if(e.getButton() == MouseEvent.BUTTON3) //If the button is right clicked
					{
						//If the cell is not already flagged, flag cell
						if(!cell.buttonIsFlagged())
						{
							frame.getController().flagCell(cell, button);
							if(frame.getModel().getValueOfCell(cell.getCellID()) == -1)
							{
								frame.getModel().setMinesRemaining(-1);
								if(frame.getModel().getNumMines() == 0)
								{
									JOptionPane.showMessageDialog(null, "You win!");
									showBoard();
								}
								else
								{
									mineLabel.setText("Mines Remaining: " + Integer.toString(frame.getModel().getNumMines()));
								}
								
							}//End of check to see if a mine is flagged
						}
						else if(cell.buttonIsFlagged()) //If the cell is flagged, unflag it 
						{
							frame.getController().unflagCell(cell, button);
							if(frame.getModel().getValueOfCell(cell.getCellID()) == -1)
							{
								frame.getModel().setMinesRemaining(1);
								mineLabel.setText("Mines Remaining: " + Integer.toString(frame.getModel().getNumMines()));
							}
						}
						
					}//End of mouseEvent main if
				
				}//End of mousePressed
			});
			cellList.add(cell);
			panel.add(cellList.get(i).getButton());
		}//End of for loop
		
	}
	
	public void howToPlay() {
		JOptionPane.showMessageDialog(null, "Click to reveal cell, right click to flag. Right click again"
												+ " to unflag.");
	}

	public void showBoard() {
		
		for(Cell c : cellList)
		{
			c.getButton().setText((Integer.toString(frame.getModel().getValueOfCell(c.getCellID()))));
			colorCell(c);

		}//End of for each loop
		
	}

	public void colorCell(Cell c) {
		
		int valueOfCell = frame.getModel().getValueOfCell(c.getCellID());
		if(valueOfCell == -1)
		{
			c.getButton().setText("M");
			c.getButton().setBackground(Color.black);
			c.getButton().setForeground(Color.white);
		}
		else if(valueOfCell == 0)
		{
			c.getButton().setBackground(null);
			c.getButton().setForeground(Color.black);
		}
		else if(valueOfCell == 1)
		{
			c.getButton().setBackground(Color.yellow);
			c.getButton().setForeground(Color.black);
		}
		else if(valueOfCell == 2)
		{
			c.getButton().setBackground(Color.orange);
			c.getButton().setForeground(Color.black);
		}
		else if(valueOfCell > 2)
		{
			c.getButton().setBackground(Color.red);
			c.getButton().setForeground(Color.black);
		}
		
	}

	public String startNewGame() {
		
		String[] options = {"Easy", "Medium", "Hard"};
		String selection = (String) JOptionPane.showInputDialog(null, "Choose Difficulty: ",
									"New Game", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		return selection;
		
	}
	public ArrayList getCellList() {
		return cellList;
	}
}
