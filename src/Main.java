import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;

public class Main extends Canvas {

	private final String TITLE = "2D tile editor by Svante Martinsson";
	private int WIDTH = 720;
	private int HEIGHT = 720;
	private Window window;
	private Window toolBoxView;
	private BufferStrategy bs;
	private Grid grid;
	private int gridWidth = 20;
	private int gridHeight = 20;
	private Menu menu;
	private String levelName;
	private LoadMap loadMap;
	private ObjectHandler handler;
	
	public Main(){


		window = new Window();
		menu = new Menu();
		handler = new ObjectHandler();

		int newMap = JOptionPane.showConfirmDialog(null, "Do you whish to load an old map?", "Load map", JOptionPane.YES_NO_OPTION);
		
		if(newMap == JOptionPane.YES_OPTION){
			loadMap = new LoadMap();
			String fileName = JOptionPane.showInputDialog("What's the file name of the map? (With file extension!)");
			loadMap.loadMap(fileName);
		}else{
			levelName = JOptionPane.showInputDialog("Name for level");
			gridWidth = Integer.parseInt(JOptionPane.showInputDialog("Grid width"));
			gridHeight = Integer.parseInt(JOptionPane.showInputDialog("Grid height"));
		}
		
		


		window.windowSetup(TITLE, WIDTH, HEIGHT, this);
		this.createBufferStrategy(3);
		bs = this.getBufferStrategy();
		grid = new Grid(WIDTH, HEIGHT, gridWidth, gridHeight, this);
		if(newMap == JOptionPane.YES_OPTION){
			grid.setGridList(loadMap.getMap());
		}else{
			grid.initGrid();
		}
		
		addMouseListener(new MouseInput(grid, WIDTH, HEIGHT, gridWidth, gridHeight, this, handler));
		loop();

	}

	public void loop(){


		while(true){
			update();
			render();
		}

	}

	public void render(){
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();

		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);



		grid.drawGrid(g);
		menu.render(g, grid);
		handler.renderObjects(g);

		g.dispose();
		bs.show();

	}

	public void update(){

	}

	public String getLevelName(){
		return levelName;
	}
	
	public Grid getGrid(){
		return grid;
	}

	public static void main(String[] args){
		new Main();
	}

}
