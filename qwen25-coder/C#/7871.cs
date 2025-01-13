using System;\n   using System.Runtime.InteropServices;\n\n   class Program\n   {\n       [DllImport("YourMfcDll.dll", CallingConvention = CallingConvention.Cdecl)]\n       public static extern int ProcessDataAndGetXML([Out] StringBuilder outputBuffer, [In] int bufferSize);\n\n       static void Main()\n       {\n           var xmlData = new StringBuilder(1024); // Adjust size as needed\n           int result = ProcessDataAndGetXML(xmlData, xmlData.Capacity);\n           Console.WriteLine("Received XML: " + xmlData.ToString());\n       }\n   }