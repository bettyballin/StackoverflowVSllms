using System;\nusing System.Runtime.InteropServices;\n\n[ComVisible(true)]\n[ClassInterface(ClassInterfaceType.None)]\npublic class ComSessionManager : IDisposable\n{\n    private bool disposed = false;\n\n    public ComSessionManager()\n    {\n        // Constructor logic here\n    }\n\n    ~ComSessionManager()\n    {\n        Dispose(false);\n    }\n\n    public void Dispose()\n    {\n        Dispose(true);\n        GC.SuppressFinalize(this);\n    }\n\n    protected virtual void Dispose(bool disposing)\n    {\n        if (!disposed)\n        {\n            if (disposing)\n            {\n                // Free managed resources here\n            }\n\n            // Free unmanaged resources here\n\n            disposed = true;\n        }\n    }\n\n    public void SaveSessionToDatabase()\n    {\n        // Logic to serialize session information to database\n    }\n}\n\n// ASP.NET Global.asax code to hook EndRequest event\npublic class Global : System.Web.HttpApplication\n{\n    protected void Application_EndRequest(Object sender, EventArgs e)\n    {\n        var sessionManager = HttpContext.Current.Items["ComSessionManager"] as ComSessionManager;\n        if (sessionManager != null)\n        {\n            sessionManager.SaveSessionToDatabase();\n            sessionManager.Dispose();\n        }\n    }\n}