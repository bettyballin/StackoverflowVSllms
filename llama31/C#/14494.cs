using System;\nusing System.Net;\nusing System.Windows.Forms;\n\nclass MachineNameExample\n{\n    static void Main(string[] args)\n    {\n        Console.WriteLine($"Environment.MachineName: {Environment.MachineName}");\n        Console.WriteLine($"Dns.GetHostName(): {Dns.GetHostName()}");\n        Console.WriteLine($"SystemInformation.ComputerName: {SystemInformation.ComputerName}");\n        Console.WriteLine($"Environment.GetEnvironmentVariable(\"COMPUTERNAME\"): {Environment.GetEnvironmentVariable("COMPUTERNAME")}");\n    }\n}