public class MyWebFormsPage : System.Web.UI.Page\n{\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        var service = new MyService(new HttpContextWrapper(Context));\n        var currentUser = service.GetCurrentUser();\n        // Use the currentUser as needed\n    }\n}