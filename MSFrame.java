import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MSFrame extends JFrame {

	private MSModel model;
	private MSView view;
	private MSController controller;
	
	public MSFrame() {
		setTitle("Minesweeper");
		setSize(500, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		model = new MSModel(this);
		view = new MSView(this);
		controller = new MSController(this);
		
		JMenuBar fileBar = new JMenuBar();
		setJMenuBar(fileBar);
		addMenu(fileBar);
		
		add(view);
		setVisible(true);
	}
	
	public MSModel getModel() {
		return model;
	}
	public MSView getView() {
		return view;
	}
	public MSController getController() {
		return controller;
	}
	
	public void addMenu(JMenuBar fileBar) {
		
		//Create and add new menu for file commands
		JMenu fileMenu = new JMenu("File");
		fileBar.add(fileMenu);
		
		MenuHandler mh = new MenuHandler();
		MSCommandMenuItem hp = new MSCommandMenuItem("How to Play");
		MSCommandMenuItem newGame = new MSCommandMenuItem("New Game");
		MSCommandMenuItem sb = new MSCommandMenuItem("Show Board");
		MSCommandMenuItem quit = new MSCommandMenuItem("Quit");
		
		newGame.addActionListener(mh);
		hp.addActionListener(mh);
		sb.addActionListener(mh);
		quit.addActionListener(mh);
		
		fileMenu.add(hp);
		fileMenu.add(sb);
		fileMenu.add(newGame);
		fileMenu.addSeparator();
		fileMenu.add(quit);
		
	}
	
	private class MenuHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			controller.performCommand((String)((MSCommandMenuItem) e.getSource()).getCommand());
		}
	}
	
}
