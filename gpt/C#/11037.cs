using System;\n\npublic class SessionService\n{\n    public string GetUserSessionID(int userID)\n    {\n        // Simulate session retrieval logic\n        bool sessionExists = false; // Replace with actual session existence check\n\n        return sessionExists ? "sessionID" : null;\n    }\n\n    public string GetNewUserSession(int userID)\n    {\n        // Simulate creating a new session\n        return "newSessionID";\n    }\n}\n\npublic class Program\n{\n    public static void Main()\n    {\n        var sessionService = new SessionService();\n        int userID = 1;\n        bool userIsAllowedToGetSession = true;\n\n        string sessionID = sessionService.GetUserSessionID(userID);\n\n        if (string.IsNullOrEmpty(sessionID) && userIsAllowedToGetSession)\n        {\n            sessionID = sessionService.GetNewUserSession(userID);\n        }\n\n        Console.WriteLine($"Session ID: {sessionID}");\n    }\n}