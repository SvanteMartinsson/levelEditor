import java.awt.Graphics2D;

public abstract class StaticObject {
	
	public abstract void render(Graphics2D g);
	public abstract void update();
	public abstract int getX();
	public abstract int getY();
	public abstract String getName();
	
	protected int x = 0;
	protected int y = 0;
	

}
