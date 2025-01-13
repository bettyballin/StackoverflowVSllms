public class MyClass : IDisposable\n{\n    private bool disposed = false;\n\n    // Public implementation of Dispose pattern callable by consumers.\n    public void Dispose()\n    {\n        Dispose(true);\n        // Suppress finalization to avoid the finalizer being called\n        GC.SuppressFinalize(this);\n    }\n\n    // Protected implementation of Dispose pattern.\n    protected virtual void Dispose(bool disposing)\n    {\n        if (disposed)\n            return;\n\n        if (disposing)\n        {\n            // Free any other managed objects here.\n            //\n        }\n\n        // Free any unmanaged objects here.\n        //\n        disposed = true;\n    }\n\n    // Destructor\n    ~MyClass()\n    {\n        Dispose(false);\n    }\n}