import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormLetter {
	private String filename;
	private int fieldNB;
	private int lineNum;
	

	public FormLetter(String filename) {
		this.filename = filename;
		try {
			Scanner fileIn = new Scanner(Paths.get("src\\" + filename));
		}

		catch (IOException e) {
			System.out.println("Could not open file! \" " + filename
					+ "\" (No such file or directory)");
		}

	}

	public String getFilename() {
		return filename;
	}

	public boolean fillForm(DbEntry e, String outputFilename){
	MailMerge mm = new MailMerge();
	String blankSpace = "";
	PrintWriter printWriter = null;
	Pattern pattern = Pattern.compile("###\\d###|###\\d##|###\\w+###");
	Matcher matcher;
	Scanner fileIn = null;
	String line;
	int fieldNum = 0;
	try {
			fileIn = new Scanner(Paths.get("src",filename));
		
			File file = new File(System.getProperty("user.dir"),outputFilename+ ".txt");
			file.createNewFile();
			printWriter = new PrintWriter (file);
			
while (fileIn.hasNextLine()){
				
				lineNum++;
					line = fileIn.nextLine();
					matcher = pattern.matcher(line);


					
					while(matcher.find()){
					String newField = matcher.group();
					if(newField.contains("###name###")){
						try {
							invalidBlankSpace();
						} catch (InvalidBlankSpaceException e1) {
							System.out.println(lineNum+": Poorly formatted blank marker; Skipping");
							newField = newField.replaceAll("\\#*", "");
							line=line.replace(matcher.group(), newField);
						}
						
					
					}
					else if(newField.matches("###\\d##")){
						try{
							
						fieldNum = Integer.parseInt(newField);
				
						}	catch(NumberFormatException nfe){
						System.out.println(lineNum+": Poorly formatted blank number; Skipping;");
						line = line.replace(matcher.group(),blankSpace);

						}						
					}
				
					else if(newField.endsWith("###")){
						
						try{
								
						newField = newField.replaceAll("[^0-9]", "");
						fieldNum = Integer.parseInt(newField);
				
						}	catch(NumberFormatException nfe){
						System.out.println(lineNum+": Poorly formatted blank number; Skipping;");
						line = line.replace(matcher.group(),blankSpace);

						}
						}
						setFieldNum(fieldNum);
						setLineNum(lineNum);
						
						try{
						line = line.replace(matcher.group(),e.getField(fieldNum-1));
						}catch(IndexOutOfBoundsException ie){
							
							System.out.println(getLineNum()+":No field #" + getFieldNum() + " in entry " + e.toString() + 
										" Using \"\"");
						line = line.replace(matcher.group(),blankSpace);
						}
					
					}
					
		    printWriter.println(line);
			}

	}catch (IOException er) 
		 {
		 		System.out.println("Unable to generate form letter #" +mm.getLetterNum()+" ..." );
			}
	
				if(printWriter!=null){
					printWriter.close();
				}
							

	
	
			
	return true;
	
		}

	private void setFieldNum(int fieldNum) {
		fieldNB = fieldNum;
	}

	private int getFieldNum() {
		return fieldNB;
	}

	private void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	private int getLineNum() {
		return lineNum;
	}
	private void invalidBlankSpace() throws InvalidBlankSpaceException{
		throw new InvalidBlankSpaceException("Poorly formatted blank marker; Skipping;");
	
	}
private class InvalidBlankSpaceException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private InvalidBlankSpaceException(String message){
		super(message);
		
	}
}
}
