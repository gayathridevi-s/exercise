package hack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Hacker {
	private ArrayList<String> urlList;

	public Hacker(ArrayList<String> urlList) {
		this.urlList = urlList;
	}

	public void writeToFile(String fileName) {

		try {
			File file = new File(fileName);
			System.out.println(file.getAbsolutePath());
			FileWriter writer = new FileWriter(file);
			for (String eachUrl : urlList) {
				writer.write(eachUrl + "\n");

			}
			
			writer.close();

		} catch (IOException e) {
			System.out.println("An error occured while writing to file!");
			e.printStackTrace();
		}
	}
	public ArrayList<String> readFile(String fileName) throws IOException {
		ArrayList<String> history=new ArrayList<>();
		FileReader fileRead=new FileReader(fileName); //can read only character wise
		BufferedReader reader =new BufferedReader(fileRead);  //buffer reader can read line by line
		String line;
		while( (line=reader.readLine())!=null) {
			history.add(line);
		}
		return history;
	}
}
