import java.io.File;

public class main {

	private static String input = new File("").getAbsolutePath().concat("/src/files/input.txt");
	private static String output = new File("").getAbsolutePath().concat("/src/files/output.txt");

	public static void main(String[] args) {
		ComaSeparated.deleteSpace(input,input);
		ComaSeparated.comaToLatex(input, output);

	}

}
