using System;\nusing System.Runtime.InteropServices;\n\npublic class ComObjectWrapper : IDisposable\n{\n    private dynamic comObject;\n    private bool disposed = false;\n\n    // Constructor that takes the COM object\n    public ComObjectWrapper(dynamic comObject)\n    {\n        this.comObject = comObject;\n    }\n\n    // Implement the Dispose method\n    public void Dispose()\n    {\n        Dispose(true);\n        GC.SuppressFinalize(this);\n    }\n\n    // Protected Dispose method to centralize disposing logic\n    protected virtual void Dispose(bool disposing)\n    {\n        if (!disposed)\n        {\n            if (disposing)\n            {\n                // Free managed resources if there are any\n            }\n\n            // Release the COM object\n            if (comObject != null)\n            {\n                Marshal.ReleaseComObject(comObject);\n                comObject = null;\n            }\n\n            disposed = true;\n        }\n    }\n\n    // Destructor to catch cases where Dispose was not called\n    ~ComObjectWrapper()\n    {\n        Dispose(false);\n    }\n\n    // Example method to show how the wrapper can be used\n    public void SomeMethod()\n    {\n        comObject.SomeMethod();\n    }\n}