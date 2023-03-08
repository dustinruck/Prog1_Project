// Fawzi Latosh  ID:6155197
// Dustin Ruck  ID: 0234348


public class Validator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	    //char[] javTest = {'.', '8', '-', 'u', '-'};
		//String newTest="user@gmail.com";
		//String userName=".9!";
		//String passWord="W0w.Pr0ject";
		//System.out.println(isAlphaNum(javTest[4]));
		//System.out.println(isSpecialChar(javTest[0]));		 
		//System.out.println(isPrefixChar(javTest[0]));
		//System.out.println(isDomainChar(javTest[1]));
		//System.out.println(singleAtSign(newTest));
	    //System.out.println(fetchBeforeAt(newTest));
		//System.out.println(fetchAfterAt(newTest));
		//System.out.println(isPrefix(fetchBeforeAt(newTest)));   
		//System.out.println(isDomain(fetchAfterAt(newTest))); 
		//System.out.println(isEmail(newTest));		
		//System.out.println(isUsername(userName));
		//System.out.println(safePassword(passWord));
	   
	    
		
		
 }
	
	public static boolean isAlphaNum(char alphaNumeric) {                 
	      //// If a character is not a letter or digit it's not a valid domain
	 if ((alphaNumeric >= '0' && alphaNumeric <= '9') || (alphaNumeric >= 'a' && alphaNumeric <= 'z') || (alphaNumeric >= 'A' && alphaNumeric <= 'Z')){
	       return true ;
	      }else{
	       return false ;
	      }        		
	          } 
	
	public static boolean isSpecialChar(char specCharac) {                 
		 // If a character is not a  period, a dash or underscore it's not a valid domain	
	 if (specCharac == '_'  || specCharac == '-' || specCharac == '.'){
	       return true ;
	      }else{
	       return false ;
	      }        		
	          } 
       

public static boolean isPrefixChar(char prefCharac) {                 
	 // If a character is not a letter, digit,  period, dash or underscore it's not a valid domain
 	 if (isSpecialChar(prefCharac)|| isAlphaNum(prefCharac)){
 	       return true ;
 	      }else{
 	       return false ;
 	      }        		
	          }

public static boolean isDomainChar(char domCharac) {                 
	// If a character is not a letter, digit,  period, dash or underscore it's not a valid domain
	 if (isSpecialChar(domCharac)|| isAlphaNum(domCharac)){
	       return true ;
	      }else{
	       return false ;
	      }        		
      }  

public static boolean singleAtSign(String str) {                 
	
	     int count=0;
	  // Loop through the characters in the string str of the domain 
		 for (int i=0;i< (str.length()-1);i++ ) {
			// counter for @ if it's more than one it's not valid	
			 if (str.charAt(i)== '@') {count +=  1;}
				} 
					if  (count ==1) return true;
			
					else return false;
		 }

public static String fetchBeforeAt(String str) {  
	// split the email and return the part before @ as a prefix string
	String[] parts = str.split("\\@");
 String firstPart = parts[0];
 return firstPart;
	}
public static String fetchAfterAt(String str) {                 
	// split the email and return the part after @ as a domain string
	String[] parts = str.split("\\@");
 String secondPart = parts[1];
 return secondPart;
	}



public static boolean isPrefix(String prefix) {
	 
	boolean word1bt1 = false;
	boolean word1bt3 = false;
	boolean word1bt2 = false;
	boolean word1bt4 = true;
	//check if it contains at least one character.
 if (prefix.length() > 1) 
		 word1bt1 = true; 									     
 //check if it contains only  characters, underscores, periods, and dashes.
	for (int i=0;i< prefix.length();i++ ) {
	
	if ( isPrefixChar(prefix.charAt(i))== true ){
		word1bt2 = true;
	} else {word1bt2 = false;
  break;}	
 }
	////check if  the underscore, period, or dash always followed by at least one alphanumeric characters
	for (int i=0;i< prefix.length();i++ ) {
	if (( prefix.charAt(i) == '.' || prefix.charAt(i) == '-'|| prefix.charAt(i) == '_') && (isAlphaNum(prefix.charAt(i + 1))!= true)) {
		word1bt4 = false; break;
		 } 
 }
	//check if it contains only alphanumeric as the first character.							
	if (isAlphaNum(prefix.charAt(0))== true) {
		word1bt3 = true; }		    	    
	
	if (word1bt1 == true && word1bt2 == true && word1bt3 == true && word1bt4 == true) return true; 
	else return false ;


	}




public static boolean isDomain(String str) {
	
 // Split the input string into two parts using the period character as the separator
  String[] parts = str.split("\\.");
  // Store the first and second parts of the domain in separate variables
  String firstPart = parts[0];
  String secondPart = parts[1];
  
  if (firstPart.length() < 1) {
      return false;
  }
  
  if (secondPart.length() < 2) {
      return false;
  }
  
  // If either the first or second part is empty, it's not a valid domain
  if (firstPart.isEmpty() || secondPart.isEmpty()) {
      return false;
  }
  
  if (firstPart.isEmpty() || secondPart.isEmpty()) {
      return false;
  }
  
  // Loop through the characters in the first part of the domain
  for (int i = 0; i < firstPart.length(); i++) {
      char ch = firstPart.charAt(i);
    
      // If a character is not a letter, digit, period, or hyphen, it's not a valid domain
      if (isDomainChar(firstPart.charAt(i)) != true) {
	         return false;
	     }
    
      
      if ((isAlphaNum(firstPart.charAt(i))!= true) && ch == '_' ) {
          return false;
      }
      // If a period or hyphen is at the beginning or end of the first part, it's not a valid domain
      if ((isSpecialChar(ch) == true) && (i == 0 || i == firstPart.length() - 1)) {
          return false;
      }
      // If a period or hyphen is followed by a non-letter/digit character, it's not a valid domain
      if ((ch == '.' || ch == '-') && (isAlphaNum(firstPart.charAt(i + 1))!= true)) {
          return false;
      }
  }
  // Loop through the characters in the second part of the domain
  for (int i = 0; i < secondPart.length(); i++) {
      char ch = secondPart.charAt(i);
      
      // If a character is not a letter, it's not a valid domain
      if (!Character.isLetter(ch)) {
          return false;
     }
  }
  return true;	
}


public static boolean isEmail(String email) {

	// split the email into prefix and domain
 String prefix = fetchBeforeAt(email);
 String domain = fetchAfterAt(email);
	
	  // check for single @ sign
	if ((singleAtSign(email)== true)&&(isPrefix(prefix)== true)&& (isDomain(domain)== true)) {
     return true;}
	return false;
     
}
public static String isUsername(String username) {
 // check if input is empty
 if (username == null || username.isEmpty()) {
     return "";
 }
  // check if input contains more than 7 characters
   if (username.length() > 7) {
      return "";
    }
   
 // check if input contains only allowed characters
 for (int i = 0; i < username.length(); i++) {
     char c = username.charAt(i);
     if (!isAlphaNum(c) && !isSpecialChar(c)&& c!='!') {
         return "";
     }
 }

 // check if input contains at least one alphanumeric character
 boolean hasAlphaNum = false;
 for (int i = 0; i < username.length(); i++) {
     char c = username.charAt(i);
     if (isAlphaNum(c)) {
         hasAlphaNum = true;
         break;
     }
 }
 if (!hasAlphaNum) {
     return "";
 }

 

 // check if input starts with a period or dash
 char firstChar = username.charAt(0);
 if (!isPrefixChar(firstChar)) {
     return "";
 }

 // check if period or dash is always followed by at least one alphanumeric character
 for (int i = 1; i < username.length(); i++) {
      char previousChar = username.charAt(i - 1); 
      char currentChar = username.charAt(i);
   
     if (isSpecialChar(previousChar) && !isAlphaNum(currentChar)) {
         return "";
     }
 }

 // if all checks passed, return lower case input
 return username.toLowerCase();


}
public static boolean safePassword(String password) {
 boolean hasLowerCase = false;
 boolean hasUpperCase = false;
 boolean hasNumber = false;
 boolean hasSpecialChar = false;
 boolean isAlphanumeric = false;
 boolean hasConsecutiveChar = false;
 char prevChar = '\0'; // gets the null character
 int consecutiveCount = 1;
 for (char c : password.toCharArray()) {
     if (Character.isUpperCase(c)) {
         hasUpperCase = true;
     } else if (Character.isLowerCase(c)) {
         hasLowerCase = true;
     } else if (Character.isDigit(c)) {
         hasNumber = true;
     } else if (isSpecialChar(c)) {
         hasSpecialChar = true;
     }
     if (isAlphaNum(c)) {
         isAlphanumeric = true;
     }
     if (c == prevChar) {
         consecutiveCount++;
     } else {
         consecutiveCount = 1;
     }
     if (consecutiveCount >= 2) {
         hasConsecutiveChar = true;
         break;
     }
     prevChar = c;
 }
 return password.length() >= 7 && password.length() <= 15 &&
        hasLowerCase && hasUpperCase && hasNumber && hasSpecialChar &&
        isAlphanumeric && !hasConsecutiveChar;
}

}