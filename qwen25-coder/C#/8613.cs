using System;\nusing System.Web.Services;\n\npublic partial class TestDBLoader : System.Web.UI.Page\n{\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        if (!IsPostBack)\n        {\n            dbManager1.LoadDBAsync(sender, e, null);\n        }\n    }\n\n    [WebMethod]\n    public static string GetLoadDBResult()\n    {\n        // Simulate the database operation and return result\n        System.Threading.Thread.Sleep(10 * 1000); // Simulating a delay for DB operation\n        return "Finish!";\n    }\n}