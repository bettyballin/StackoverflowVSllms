using System.Runtime.InteropServices;\n\npublic class MyClass\n{\n    [DllExport("MyFunction", CallingConvention = CallingConvention.Cdecl)]\n    public static int MyFunction(int value)\n    {\n        return value * 2;\n    }\n}