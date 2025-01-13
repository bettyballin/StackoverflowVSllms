using System;\nusing System.Security;\n\npublic partial class MyPage : System.Web.UI.Page\n{\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        try\n        {\n            // Code that's causing the error\n            string tempPath = System.IO.Path.GetTempPath();\n            // ...\n        }\n        catch (SecurityException ex)\n        {\n            // Log the error\n            LogError(ex);\n            // Display an error message\n            Response.Write("An error occurred: " + ex.Message);\n        }\n    }\n\n    private void LogError(Exception ex)\n    {\n        // Log the error using a logging framework\n        log4net.ILog logger = log4net.LogManager.GetLogger(typeof(MyPage));\n        logger.Error(ex);\n    }\n}