[ComVisible(true)]\npublic class SessionWrapper : IDisposable\n{\n    private SessionObject _session;\n\n    public SessionWrapper()\n    {\n        _session = new SessionObject();\n    }\n\n    public void Dispose()\n    {\n        _session.Dispose();\n    }\n}