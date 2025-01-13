public class Global : HttpApplication\n{\n    void Session_Start(object sender, EventArgs e)\n    {\n        // Code that runs when a new session is started\n        Application.Lock();\n        int numActiveSessions = (int)Application["OnlineUsers"] + 1;\n        Application["OnlineUsers"] = numActiveSessions;\n        Application.UnLock();\n\n        // Optionally log the Session ID or other information\n        var sessionId = HttpContext.Current.Session.SessionID;\n    }\n\n    void Session_End(object sender, EventArgs e)\n    {\n        // Code that runs when a session ends. \n        // Note: The Session object is already null by the time this event is raised.\n        Application.Lock();\n        int numActiveSessions = (int)Application["OnlineUsers"] - 1;\n        Application["OnlineUsers"] = numActiveSessions;\n        Application.UnLock();\n\n        // Optionally log the event or session ID if stored previously\n    }\n}