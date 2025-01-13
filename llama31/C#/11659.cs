using System;\nusing System.Runtime.InteropServices;\n\n[ComVisible(true)]\npublic class SessionObject : IDisposable\n{\n    // ...\n\n    ~SessionObject()\n    {\n        // This is the finalizer, not guaranteed to be called immediately\n        Dispose(false);\n    }\n\n    public void Dispose()\n    {\n        // Implement your cleanup logic here\n        // This will be called when Dispose() is explicitly called\n        Dispose(true);\n        GC.SuppressFinalize(this);\n    }\n\n    protected virtual void Dispose(bool disposing)\n    {\n        if (disposing)\n        {\n            // Free managed resources\n        }\n        // Free unmanaged resources\n    }\n}