public class SessionTracker\n{\n    private static readonly ConcurrentDictionary<string, SessionInfo> _sessions = new ConcurrentDictionary<string, SessionInfo>();\n\n    public static void AddSession(string sessionId, string ipAddress)\n    {\n        _sessions.TryAdd(sessionId, new SessionInfo { IpAddress = ipAddress });\n    }\n\n    public static void RemoveSession(string sessionId)\n    {\n        _sessions.TryRemove(sessionId, out _);\n    }\n\n    public static IEnumerable<SessionInfo> GetSessions()\n    {\n        return _sessions.Values;\n    }\n}\n\npublic class SessionInfo\n{\n    public string IpAddress { get; set; }\n}\n\n// In Global.asax\nprotected void Session_Start(object sender, EventArgs e)\n{\n    string sessionId = Session.SessionID;\n    string ipAddress = Request.UserHostAddress;\n    SessionTracker.AddSession(sessionId, ipAddress);\n}\n\nprotected void Session_End(object sender, EventArgs e)\n{\n    string sessionId = Session.SessionID;\n    SessionTracker.RemoveSession(sessionId);\n}