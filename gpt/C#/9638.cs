using System;\n\nclass Program\n{\n    static void Main()\n    {\n        // Handle Ctrl+C and other close events\n        Console.CancelKeyPress += new ConsoleCancelEventHandler(OnExit);\n        AppDomain.CurrentDomain.ProcessExit += new EventHandler(OnProcessExit);\n\n        Console.WriteLine("Press Ctrl+C to exit or close the window to trigger the events.");\n        \n        // Keep the application running\n        while (true)\n        {\n            // Simulate work\n            System.Threading.Thread.Sleep(1000);\n        }\n    }\n\n    static void OnExit(object sender, ConsoleCancelEventArgs args)\n    {\n        Console.WriteLine("Exiting via Ctrl+C or Ctrl+Break");\n        // Perform cleanup here\n        args.Cancel = true; // Set to false if you want to terminate the process\n    }\n\n    static void OnProcessExit(object sender, EventArgs e)\n    {\n        Console.WriteLine("Process is exiting");\n        // Perform cleanup here\n    }\n}