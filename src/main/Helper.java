package main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Helper {
	public static void setFile(String file){
		try {
			file = file.replace("/", File.separator);
			System.setIn(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
