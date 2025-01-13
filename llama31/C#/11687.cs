public class MyClass\n{\n    private IntPtr unmanagedResource;\n\n    public MyClass()\n    {\n        unmanagedResource = AllocateUnmanagedResource();\n    }\n\n    ~MyClass() // Finalizer\n    {\n        ReleaseUnmanagedResource(unmanagedResource);\n    }\n\n    private IntPtr AllocateUnmanagedResource()\n    {\n        // Allocate an unmanaged resource, e.g., a file handle\n    }\n\n    private void ReleaseUnmanagedResource(IntPtr resource)\n    {\n        // Release the unmanaged resource\n    }\n}