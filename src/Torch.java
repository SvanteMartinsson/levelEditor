import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Torch extends StaticObject{

	private Image imageOne;
	private Image imageTwo;
	private Grid grid;
	private BufferedImage tileSet;
	private int counter = 0;
	private String name;
	
	public Torch(int x, int y, Grid grid){
		this.x = x;
		this.y = y;
		this.grid = grid;
		try {
			tileSet = ImageIO.read(new FileInputStream("res/tilesBasic.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		imageOne = tileSet.getSubimage(64, 112, 16, 16);
		imageTwo = tileSet.getSubimage(80, 112, 16, 16);
		name = "TORCH";
		
	}
	
	public void render(Graphics2D g) {
		
		if(counter<25){
			g.drawImage(imageOne, x-16, y-16, grid.getBlocksWidth()+16, grid.getBlocksHeight()+13, null);
		}else{
			g.drawImage(imageTwo, x-16, y-16, grid.getBlocksWidth()+16, grid.getBlocksHeight()+13, null);
			if(counter == 50){
				counter = 0;
			}
		}
		
		counter++;
		
	}

	
	public void update() {		
		
	}
	
	public String getName(){
		return name;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	

}
