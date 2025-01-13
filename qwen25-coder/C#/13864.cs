using System;\n\npublic class SomeClass : IDisposable\n{\n    private IntPtr unmanagedResourceHandle; // Handle to some unmanaged resource\n    private ManagedResource managedResource;\n    private bool disposedValue = false;\n\n    public void SomeMethod()\n    {\n        // Use your resource here.\n    }\n\n    protected virtual void Dispose(bool disposing)\n    {\n        if (!disposedValue)\n        {\n            if (disposing)\n            {\n                // Free any managed objects held in references\n                if (managedResource != null)\n                {\n                    managedResource.Dispose();\n                    managedResource = null;\n                }\n            }\n\n            // Free any unmanaged objects and set to null\n            unmanagedResourceHandle = IntPtr.Zero;\n\n            disposedValue = true;\n        }\n    }\n\n    // This code is added to correctly implement the disposable pattern.\n    public void Dispose()\n    {\n        // Do not change this code. Put cleanup code in Dispose(bool disposing) above.\n        Dispose(true);\n        GC.SuppressFinalize(this);\n    }\n\n    ~SomeClass()\n    {\n        Dispose(false);\n    }\n}