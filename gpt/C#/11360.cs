using System;\nusing System.Runtime.InteropServices;\n\nnamespace ComInteropExample\n{\n    [ComVisible(true)]\n    [ClassInterface(ClassInterfaceType.AutoDual)]\n    public class DataReader\n    {\n        public DataReader() { }\n\n        public string GetStringData(int id)\n        {\n            // Example method that returns a string based on an integer input\n            return "Data for ID: " + id.ToString();\n        }\n\n        public int AddNumbers(int a, int b)\n        {\n            // Example method that adds two integers\n            return a + b;\n        }\n    }\n}