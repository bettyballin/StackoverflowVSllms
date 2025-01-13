using System;\nusing System.Runtime.InteropServices;\n\nclass Program {\n    [DllImport("yourCppDll.dll", CallingConvention = CallingConvention.Cdecl)]\n    public static extern int YourFunction();\n\n    static void Main(string[] args) {\n        try {\n            var result = YourFunction();\n            Console.WriteLine($"Function returned: {result}");\n        } catch (Exception ex) {\n            Console.WriteLine($"Error calling DLL function: {ex.Message}");\n        }\n    }\n}