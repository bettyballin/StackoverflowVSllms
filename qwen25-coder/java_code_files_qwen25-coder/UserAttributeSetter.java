import java.lang.String;
public abstract class UserAttributeSetter {
    public enum UserAttribute {
          NAME,
          AGE,
          ADDRESS;
          
          private String value;
          UserAttribute() {}
          public String getValue() { return name().toLowerCase(); } // assuming snake_case in API
      }
      
      public abstract void setUserAttribute(UserAttribute attribute, Object value);

    	public static void main(String[] args) {
    	}
}