import java.io.Serializable;
import java.util.ArrayList;
public class DbEntry implements Serializable{

private ArrayList<String> fields = new ArrayList<String>();

public DbEntry(String entry){
 parseDBEntry(entry);
}

private void parseDBEntry(String entry){

	int endIndex = entry.length();
	int colonIndex1 = entry.indexOf(':');
	int colonIndex2 = entry.indexOf(":", colonIndex1+1);
for(int i = 0 ;i <=entry.length(); i++){
	String newField = entry.substring(colonIndex1+1,colonIndex2);
	fields.add(newField);
	 if(colonIndex2<entry.length()-1){
		 colonIndex1 = entry.indexOf(":", colonIndex2);
		 colonIndex2 = entry.indexOf(":", colonIndex1+1);
		 i = colonIndex2;
	 }
	 else{
		 newField = entry.substring(colonIndex1+1, endIndex);
	 }
	 
}
}
public String getField(int field) throws IndexOutOfBoundsException{
	
	
		fields.get(field);
			
	
	
	
	return fields.get(field);
}

public String toString(){
	String s ="";
	for(int i=0; i<fields.size();i++){
		s+=":"+fields.get(i);
	}
	return s;
	
}
}
