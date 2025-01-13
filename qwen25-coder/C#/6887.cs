using System;\n   using System.IO.Ports;\n\n   class Program\n   {\n       static void Main()\n       {\n           string[] ports = SerialPort.GetPortNames();\n           foreach (string port in ports)\n           {\n               Console.WriteLine(port);\n           }\n\n           try\n           {\n               using (SerialPort mySerialPort = new SerialPort("COM2"))\n               {\n                   mySerialPort.Open();\n                   Console.WriteLine("Port opened successfully.");\n                   mySerialPort.Close();\n               }\n           }\n           catch (UnauthorizedAccessException e)\n           {\n               Console.WriteLine(e.ToString());\n           }\n           catch (IOException e)\n           {\n               Console.WriteLine(e.ToString());\n           }\n       }\n   }