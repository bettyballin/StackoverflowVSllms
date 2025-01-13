public partial class MyPage : Page\n{\n    private SessionManager _sessionManager = new SessionManager();\n\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        string pageKey = (string)ViewState["PageKey"];\n        if (pageKey == null)\n        {\n            pageKey = Guid.NewGuid().ToString();\n            ViewState["PageKey"] = pageKey;\n        }\n        // Use pageKey to store and retrieve session data\n    }\n}