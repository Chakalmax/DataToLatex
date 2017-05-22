import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ComaSeparated {

	public static void comaToLatex(String input,String output){
		ArrayList<String> strList = readFile(input);
		writeTo(strList,output);
}

	private static void writeTo(ArrayList<String> strList, String output) {
		try(BufferedWriter out = new BufferedWriter(new FileWriter(output));){
			for(String line : strList){
				out.append(line);
				out.newLine();
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static ArrayList<String> readFile(String input) {
		ArrayList<String> linesList = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(input));){
			String line = br.readLine();
			while(line != null){
				ArrayList<String> linesplit = new ArrayList<String>(Arrays.asList(line.split(",")));
				String newLine =linesplit.get(0);
				for(int i=1; i<linesplit.size();i++){
					newLine = newLine+"&"+linesplit.get(i);
				}
				newLine = newLine + "\\\\"; // \\ déspécialise le \, donc il en faut 4.
				linesList.add(newLine);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return linesList;
	}
	/**
	 * This function delete space if needed(bad copy-pasta from strange files for example)
	 * @param input
	 * @param output
	 */
	public static void deleteSpace(String input,String output){
		ArrayList<String> linesList = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(input));){
			String line = br.readLine();
			while(line != null){
				ArrayList<String> linesplit = new ArrayList<String>(Arrays.asList(line.split(" ")));
				String newLine =linesplit.get(0);
				for(int i=1; i<linesplit.size();i++){
					newLine = newLine+linesplit.get(i);
				}
				linesList.add(newLine);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writeTo(linesList,output);
	}
}
