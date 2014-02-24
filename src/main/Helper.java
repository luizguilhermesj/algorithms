package main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

import edu.princeton.cs.introcs.StdOut;


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
	
	public static void printArray(Comparable[] a, int i){
		StdOut.print(i+": ");
		for (Comparable item : a)
			StdOut.print(item.toString()+ ' ');
		StdOut.println();
	}
}
