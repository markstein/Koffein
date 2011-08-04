package de.wholestone.fitsizer;

import java.io.File;

public class FitSizer {

	enum Message {
		NO_ARGUMENTS("No Arguments"),
		DIR_NOT_EXISTS("Das angegebene Verzeichnis '%s' existiert nicht!");
	
		private final String message;

		private Message(String message) {
			this.message = message;
		}

		public String withParameter(Object... parameters) {
			return String.format(plain(), parameters);
		}
		
		public String plain() {
			return message;
		}
	}

	private final String[] args;

	public FitSizer(String... args) {
		this.args = args;		
	}

	public boolean validateParameters() {
		if(args == null || args.length < 2){
			System.out.println(Message.NO_ARGUMENTS.plain());
			return false;
		}
		String dirName = args[0];
		File dir = new File(dirName);
		if (!dir.exists()) {
			System.out.println(Message.DIR_NOT_EXISTS.withParameter(dirName));
			return false;
		}
		return true;
	}
	
	public static void main(String... args) {
		new FitSizer(args);
	}
}
