using System;\nusing System.Runtime.InteropServices;\n\nnamespace YourNamespace\n{\n    [ComVisible(true)]\n    [Guid("YOUR-GUID-HERE")]\n    [InterfaceType(ComInterfaceType.InterfaceIsIDispatch)]\n    public interface IYourInterface\n    {\n        YourReturnType Method1(string arg1);\n        YourReturnType Method1_Overload(string arg1, string arg2);\n    }\n\n    [ComVisible(true)]\n    [Guid("YOUR-GUID-HERE")]\n    [ClassInterface(ClassInterfaceType.None)]\n    public class YourClass : IYourInterface\n    {\n        public YourReturnType Method1(string arg1)\n        {\n            // Your implementation here\n        }\n\n        public YourReturnType Method1_Overload(string arg1, string arg2)\n        {\n            // Your implementation here\n        }\n    }\n}