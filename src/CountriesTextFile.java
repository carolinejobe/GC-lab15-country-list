import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class CountriesTextFile {

	static Scanner input = new Scanner(System.in);
	static File myTextFile = null;
	static JTextPane textPane = new JTextPane();
	static Path absPath;
	
	public static String loadCountries(){
		String countryList = "";
		String fName = "countries.txt";
		Path p = Paths.get(fName);
		String newLine = System.getProperty("line.separator");
		
		absPath = p.toAbsolutePath();
		if (Files.notExists(absPath)) {
			try {
				Files.createFile(absPath);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "File creation error.");
			}
		}
		try {
			myTextFile = absPath.toFile();
			FileReader fReader = new FileReader(myTextFile);
			BufferedReader reader = new BufferedReader(fReader);
			
			String line = reader.readLine();
			while (line!=null){
				countryList = countryList + line + newLine;
				line = reader.readLine();
			}
			
			reader.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "File creation error.");
		}
		return countryList;
	}
	
	public static void addCountry(String countryList, String newCountry){
		File myTextFile = absPath.toFile();
		PrintWriter writer;
		try {
			writer = new PrintWriter(myTextFile);
			writer.write(countryList + newCountry);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null,"Click the load button to update the list with your country.");
	}
}
