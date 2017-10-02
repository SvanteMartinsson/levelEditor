import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class SaveMap {

	public void saveMapToTxtFile(int[][] map, int gridWidth, int gridHeight, Main main, ObjectHandler handler){


		try {
			PrintWriter out = new PrintWriter(new FileWriter(main.getLevelName() + ".dat"));
			out.write(gridWidth + ":" + gridHeight + "\n");
			for(int y = 0; y < main.getGrid().getGridHeight(); y++){
				for(int x = 0; x < main.getGrid().getGridWidth(); x++){
					out.write(Integer.toString(map[x][y]));
					System.out.print(map[x][y]);
				}
				out.write("\n");
				System.out.print("\n");
			}
			
			for(int i = 0; i < handler.getStaticObjectList().size(); i++){
				out.write(Integer.toString(handler.getX(i)) + "," + Integer.toString(handler.getY(i)) + "," + handler.getName(i) + "\n");
				System.out.println(Integer.toString(handler.getX(i)) + "," + Integer.toString(handler.getY(i)) + "," + handler.getName(i) + "\n");
			}

			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Map saved!");



	}


}
