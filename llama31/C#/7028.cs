public partial class MyPage : Page\n{\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        if (!IsPostBack)\n        {\n            ViewState["MyVariable"] = "Hello, World!";\n        }\n    }\n\n    protected void Button_Click(object sender, EventArgs e)\n    {\n        string myVariable = (string)ViewState["MyVariable"];\n        // Do something with myVariable\n    }\n}