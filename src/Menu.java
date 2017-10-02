import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;

public class Menu {
	
	private LinkedList<menuItem> itemList = new LinkedList<menuItem>();

	public void render(Graphics2D g, Grid grid){
		g.setColor(Color.BLACK);
		g.fillRect( 10, 635, 100, 40);
		g.setColor(Color.white);
		g.drawString("Save", 40, 660);
		
		//addMenuItem(125, 635, 50, 40, Color.RED);
		//addMenuItem(215, 635, 50, 40, Color.GREEN);
		
		grid.getTileset().drawTile(g, "FLOOR_BASIC", 125, 635);
		grid.getTileset().drawTile(g, "STONE_WALL", 215, 635);
		grid.getTileset().drawTile(g, "FLOOR_LAVA", 305, 635);
		grid.getTileset().drawTile(g, "ZOMBIE_SPAWNER", 400, 635);
		grid.getTileset().drawTile(g, "TORCH", 495, 635);
		
		/*for(int i = 0; i < itemList.size(); i++){
			g.setColor(Color.black);
			g.drawRect(itemList.get(i).getX()-2, itemList.get(i).getY()-2, itemList.get(i).getWidth()+3, itemList.get(i).getHeight()+3);
			g.setColor(itemList.get(i).getColor());
			g.fillRect(itemList.get(i).getX(), itemList.get(i).getY(), itemList.get(i).getWidth(), itemList.get(i).getHeight());
		}*/
		
	}
	
	public void addMenuItem(int x, int y, int width, int height, Color color){
		itemList.add(new menuItem(x, y, width, height, color));
	}



}
