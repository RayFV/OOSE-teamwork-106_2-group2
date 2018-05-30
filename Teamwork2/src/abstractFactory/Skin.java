package abstractFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Skin {
	private static final String FILENAME = "Skin.txt";
	private static Skin instance = new Skin();

	private BufferedReader br = null;
	private FileReader fr = null;
	
	private String skin;
	
	private Skin() {
		try {
			//System.out.println("Working Directory = " + System.getProperty("user.dir"));
			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			if ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				skin = sCurrentLine;
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

	}
	
	public static Skin getInstance() {
		return instance;
	}
	
	public String getSkin() {
		return this.skin;
	}
	
}
