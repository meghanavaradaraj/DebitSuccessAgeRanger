package stepDefinitions;

public class parameters {
	private final String seleniumChromePath = "./drivers/chromedriver";
	//private final String seleniumChromePath = "./drivers/chromedriver.exe";
	private final String seleniumGeckoPath = "./drivers/geckodriver.exe";

	// Sequence counter for screenshots
	private static int sequenceCounter;

	public String getGeckoPath() {
		return seleniumGeckoPath;
	}

	public String getChromePath() {
		return seleniumChromePath;
	}

	public static int getSequenceCounter() {
		return sequenceCounter;
	}

	public static void incrementSequenceCounter() {
		sequenceCounter++;
	}

	public static String getBrowser() {
		return "chrome";
	}

}
