import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class MailMerge {
	static int letterNum = 0;
	
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		System.out.println("Mail Merge" +'\n'+ "==========");
		String dbS = "Enter name of database file: ";
		String flS = "Enter name of form file: ";
		
		int i =1;
		String line = "";
		while(i == 1)
		try {
			System.out.print(dbS);
			String filenameIn= stdIn.nextLine();

			if(filenameIn.equalsIgnoreCase("q"))
			{
				System.out.println("Goodbye!");
				System.exit(0);	
			}
			else{
				Scanner fileIn = new Scanner(Paths.get("src\\",filenameIn));
				System.out.print(flS);
				String FormletterIn= stdIn.nextLine();
				DbEntry dbe;
				while (fileIn.hasNextLine())
				 {
					dbe=new DbEntry(fileIn.nextLine());
					letterNum++;
					System.out.println("Generating form letter #" + letterNum +" ...");
					FormLetter fl =new FormLetter(FormletterIn);
					try{
					generateNewForm(fl,dbe,FormletterIn);
					}catch(StringIndexOutOfBoundsException sob){
						
					}
					i=0;
				 }
			}
		}catch (IOException e) {
			System.out.println("Unable to open file \"" + e.getMessage() + "\" (No such file or directory)");
			dbS= "Enter different filename, or 'q' to quit: ";
			}
		System.out.println("Merge Completed.");
		System.out.println("GoodBye!");
	}
	
	public int  getLetterNum(){
		return letterNum;
	}
	
	private static void generateNewForm(FormLetter f,DbEntry e, String fileInName){
		String outputName = fileInName.substring(0, fileInName.indexOf("."))+letterNum;
		f.fillForm(e, outputName);
		
	}
	}


