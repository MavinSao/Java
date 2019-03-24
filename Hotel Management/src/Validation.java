
public class Validation {
	  static boolean isValidate(String value) {
		  try {
		  	int values = Integer.valueOf(value);
		  	if(values>0) {
		  		return true;
		  	}
		  	else {
		  		System.out.println("value must be greater than 0");
		  		return false;
		  	}
		   }catch (Exception e) {
			 System.out.println("Invalid number.....");
			 return false;
		   }
  	
	  }
	
}
