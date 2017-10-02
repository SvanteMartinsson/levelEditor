import java.awt.Graphics2D;

public class Spawner extends StaticObject{
	
	private Grid grid;
	private String name;
	
	public Spawner(int x, int y, Grid grid){
		this.x = x;
		this.y = y;
		this.grid = grid;
		name = "SPAWNER";
	}
	
	public void render(Graphics2D g){
		grid.getTileset().drawTile(g, "ZOMBIE_SPAWNER", x-16, y-16);
	}

	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public String getName(){
		return name;
	}

}
