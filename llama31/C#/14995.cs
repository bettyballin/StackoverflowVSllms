public class SessionManager\n{\n    private const int MAX_INACTIVE_INTERVAL = 30; // in minutes\n    private Dictionary<string, SessionData> _sessionData = new Dictionary<string, SessionData>();\n\n    public void AddSessionData(string pageKey, object data)\n    {\n        _sessionData[pageKey] = new SessionData(data);\n    }\n\n    public object GetSessionData(string pageKey)\n    {\n        if (_sessionData.TryGetValue(pageKey, out SessionData data))\n        {\n            data.LastAccessed = DateTime.Now;\n            return data.Data;\n        }\n        return null;\n    }\n\n    public void ExpireSessionData()\n    {\n        var now = DateTime.Now;\n        var expiredKeys = _sessionData.Where(x => (now - x.Value.LastAccessed).TotalMinutes > MAX_INACTIVE_INTERVAL)\n                                      .Select(x => x.Key)\n                                      .ToList();\n        foreach (var key in expiredKeys)\n        {\n            _sessionData.Remove(key);\n        }\n    }\n\n    private class SessionData\n    {\n        public object Data { get; set; }\n        public DateTime LastAccessed { get; set; }\n\n        public SessionData(object data)\n        {\n            Data = data;\n            LastAccessed = DateTime.Now;\n        }\n    }\n}