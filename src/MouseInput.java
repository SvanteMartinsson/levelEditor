import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter{

	private Grid grid;
	private int wWidth = 0;
	private int wHeight = 0;
	private int gridWidth = 0;
	private int gridHeight = 0;
	private SaveMap save;
	private Main main;
	private int currNum;
	private ObjectHandler handler;

	public MouseInput(Grid grid, int wWidth, int wHeight, int gridWidth, int gridHeight, Main main, ObjectHandler handler){
		this.grid = grid;
		this.wWidth = wWidth;
		this.wHeight = wHeight;
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
		this.main = main;
		currNum = 1;
		save = new SaveMap();
		this.handler = handler;

	}

	public void mousePressed(MouseEvent me){
		int mX = me.getX();
		int mY = me.getY();

		int x = mX/(wWidth/gridWidth);
		int y = mY/((wHeight-100)/gridHeight);

		System.out.println("Real cordinates: x = " + mX + " y = " + mY + " Block cordinates x =  " + x + " " + y);



		if(me.getButton() == MouseEvent.BUTTON1){
			
			if(mY<620){
				if(currNum<10){
					grid.setGridItem(x, y, currNum);
				}else{
					if(currNum == 10){
						handler.addStaticObject(new Spawner(mX, mY, grid));
					}else if(currNum == 11){
						handler.addStaticObject(new Torch(mX, mY, grid));
					}
				}
				
			}
			
			if(mX>215 && mX<265){
				if(mY>635 && mY<675){
					currNum = 2;
				}
			}
			
			if(mX>125 && mX<175){
				if(mY>635 && mY<675){
					currNum = 1;
				}
			}
			
			if(mX>400 && mX<450){
				if(mY>635 && mY<675){
					currNum = 10;
				}
			}
			
			if(mX>305 && mX<355){
				if(mY>635 && mY<675){
					currNum = 3;
				}
			}
			
			if(mX>495 && mX<545){
				if(mY>635 && mY<675){
					currNum = 11;
				}
			}

			if(mX>10 && mX<110){
				if(mY>635 && mY< 675){
					save.saveMapToTxtFile(grid.getMap(), gridWidth, gridHeight, main, handler);
				}
			}


		}else if(me.getButton() == MouseEvent.BUTTON3){
			grid.setGridItem(x, y, 0);
		}


	}
	

}
