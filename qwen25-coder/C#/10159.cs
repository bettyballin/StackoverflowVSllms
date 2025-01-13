using System;\n\npublic class SessionManager : IDisposable\n{\n    // Your session logic here\n\n    public void SerializeSession()\n    {\n        // Logic to serialize the session back to the database\n        Console.WriteLine("Serializing session...");\n    }\n\n    #region IDisposable Support\n    private bool disposedValue = false; // To detect redundant calls\n\n    protected virtual void Dispose(bool disposing)\n    {\n        if (!disposedValue)\n        {\n            if (disposing)\n            {\n                SerializeSession();\n            }\n            \n            disposedValue = true;\n        }\n    }\n\n    public void Dispose()\n    {\n        // Do not change this code. Put cleanup code in Dispose(bool disposing) above.\n        Dispose(true);\n        GC.SuppressFinalize(this);\n    }\n    #endregion\n}\n\npublic static class SessionManagerFactory\n{\n    private static readonly Lazy<SessionManager> _sessionManager = new Lazy<SessionManager>(() => new SessionManager());\n\n    public static SessionManager GetSessionManager()\n    {\n        return _sessionManager.Value;\n    }\n\n    // Method to ensure disposal of the singleton instance when needed.\n    public static void DisposeSessionManager()\n    {\n        if (_sessionManager.IsValueCreated)\n        {\n            _sessionManager.Value.Dispose();\n        }\n    }\n}