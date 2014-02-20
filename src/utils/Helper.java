package utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Helper {

	public static void setFile(String filePath){
		try {
			System.setIn(new FileInputStream(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
