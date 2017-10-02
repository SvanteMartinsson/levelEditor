import java.awt.Graphics2D;
import java.util.LinkedList;

public class ObjectHandler {
	
	private LinkedList<StaticObject> staticObjectList = new LinkedList<StaticObject>();
	
	public void addStaticObject(StaticObject obj){
		staticObjectList.add(obj);
	}
	
	public void renderObjects(Graphics2D g){
		for(StaticObject obj : staticObjectList){
			obj.render(g);
		}
	}
	
	public int getX(int i){
		return staticObjectList.get(i).getX();
	}
	
	public int getY(int i){
		return staticObjectList.get(i).getY();
	}
	
	public String getName(int i){
		return staticObjectList.get(i).getName();
	}
	
	public LinkedList getStaticObjectList(){
		return staticObjectList;
	}

}
