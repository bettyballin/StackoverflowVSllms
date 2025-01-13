using System;\nusing System.Web;\nusing System.Web.SessionState;\n\npublic class SessionEventModule : IHttpModule\n{\n    public void Init(HttpApplication app)\n    {\n        SessionStateModule sessionModule = (SessionStateModule)app.Modules["Session"];\n        sessionModule.Start += new EventHandler(Session_Start);\n        sessionModule.End += new EventHandler(Session_End);\n    }\n\n    public void Dispose() { }\n\n    public void Session_Start(object sender, EventArgs e)\n    {\n        // Code to run on Session Start\n    }\n\n    public void Session_End(object sender, EventArgs e)\n    {\n        // Code to run on Session End\n    }\n}