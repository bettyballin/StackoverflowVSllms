import com.opensymphony.xwork2.ActionSupport;

public class LoginAction_1_1 extends ActionSupport {
  @Override
  public String execute() {
    // Your execution logic here
    return "success";
  }

  public static void main(String[] args) {
    // You might want to create an instance of LoginAction_1 and call its execute method here for testing
    LoginAction_1 loginAction = new LoginAction_1();
    System.out.println(loginAction.execute());
  }
}