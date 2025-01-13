using System;\nusing System.Runtime.InteropServices;\n\n// Define the interface you expose to COM.\n[Guid("YOUR-GUID-HERE"), InterfaceType(ComInterfaceType.InterfaceIsDual)]\npublic interface IMyOutProcServer\n{\n    void RunVB6COMObject();\n}\n\n// Implement the interface in a class. This class will be used by your VB6 app.\n[Guid("YOUR-GUID-HERE"), ClassInterface(ClassInterfaceType.None)]\n[ProgId("MyCompany.MyOutProcServer")]\npublic class MyOutProcServer : IMyOutProcServer\n{\n    public void RunVB6COMObject()\n    {\n        // Create an instance of the VB6 COM object and call its method.\n        Type vbComObjectType = Type.GetTypeFromProgID("VB6ComObjectName");\n        object vbComObjectInstance = Activator.CreateInstance(vbComObjectType);\n        \n        // Call a method on the VB6 COM object\n        vbComObjectType.InvokeMember("MethodName", System.Reflection.BindingFlags.InvokeMethod, null, \n            vbComObjectInstance, new object[] { /* parameters */ });\n    }\n}