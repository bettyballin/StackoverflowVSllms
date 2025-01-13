public class SessionObjectWrapper : IDisposable\n{\n    // ...\n\n    ~SessionObjectWrapper()\n    {\n        Dispose(false);\n    }\n\n    public void Dispose()\n    {\n        Dispose(true);\n        GC.SuppressFinalize(this);\n    }\n\n    protected virtual void Dispose(bool disposing)\n    {\n        // Dispose of managed resources here\n        if (disposing)\n        {\n            // ...\n        }\n        // Dispose of unmanaged resources here\n    }\n}