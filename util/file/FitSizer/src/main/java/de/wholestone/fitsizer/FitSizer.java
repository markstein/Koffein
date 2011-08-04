package de.wholestone.fitsizer;

import java.io.File;

public class FitSizer {

//	// Enums
//	xxx;
	public static final String NO_ARGUMENTS = "No Arguments";
	public static final String DIR_NOT_EXISTS = "Das angegebene Verzeichnis '%s' existiert nicht!";

	private final String[] args;

	public FitSizer(String... args) {
		this.args = args;		
	}

	public boolean validateParameters() {
		if(args == null || args.length < 2){
			System.out.println(NO_ARGUMENTS);
			return false;
		}
		File directory = new File(args[0]);
		if (!directory.exists()) {
			System.out.println(String.format(DIR_NOT_EXISTS, args[0]));
			return false;
		}
		return true;
	}
	
	public static void main(String... args) {
		new FitSizer(args);
	}
}
