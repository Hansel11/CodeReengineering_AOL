package cr_aol_utility;

public class IOUtility {

	public IOUtility() {
		
	}

	public static void printLine() {
		for(int i=0;i<141;i++)System.out.print("=");
		System.out.println();
	}

	public static void pressEnter() {
		System.out.println("Press enter to continue...");
		FileUtility.sc.nextLine();
	}

	public static int inputInt() {
		int input = -1;
		try {
			input = FileUtility.sc.nextInt();
		}catch(Exception ex) {}
		FileUtility.sc.nextLine();
		return input;
	}

}
