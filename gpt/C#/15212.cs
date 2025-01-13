using System;\nusing System.Diagnostics;\n\npublic class Program\n{\n    public static void Main()\n    {\n        Process myprocess = new Process();\n        myprocess.StartInfo.FileName = "notepad.exe"; // Example process\n        myprocess.EnableRaisingEvents = true;\n        myprocess.Exited += new EventHandler(myprocess_Exited);\n        myprocess.Start();\n\n        // Wait for the process to exit to ensure the event is fired\n        myprocess.WaitForExit();\n    }\n\n    private static void myprocess_Exited(object sender, EventArgs e)\n    {\n        // Here we simulate updating a label in a console application for demonstration\n        Console.WriteLine("Process end...");\n    }\n}