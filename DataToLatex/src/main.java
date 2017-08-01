import java.io.File;

public class main {

	private static String input = new File("").getAbsolutePath().concat("/src/files/input.txt");
	private static String output = new File("").getAbsolutePath().concat("/src/files/output.txt");

	public static void main(String[] args) {
		System.out.println("Path du projet :" + new File("").getAbsolutePath());
		ComaSeparated.deleteThing(input,input," ");
		//ComaSeparated.comaToLatex(input, output);
		ComaSeparated.comaToSpace(input, output);

	}

}
