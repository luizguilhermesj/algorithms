package main;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Helper {
	public static void setFile(String file){
		try {
			System.setIn(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
