static void Main(string[] args)\n{\n    ServiceSoapClient s = new ServiceSoapClient("ServiceSoap");\n    s.ClientCredentials.Windows.ClientCredential = new System.Net.NetworkCredential("username", "password", "domain");\n\n    try\n    {\n        Service.RawGpsData[] result = s.GetRawGpsData(0);\n        Console.WriteLine(String.Format("done: {0}", result.Length));\n    }\n    catch (Exception ex)\n    {\n        Console.WriteLine("Error: " + ex.Message);\n    }\n\n    Console.ReadLine();\n}