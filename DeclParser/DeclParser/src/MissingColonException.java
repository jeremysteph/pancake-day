
public class MissingColonException extends RuntimeException {

	private String identifierText;

	public MissingColonException(String text){
		

	}
	public String getIDText(){
		String text = "ERROR: Missing semicolon";
		return text;
	}
	}
