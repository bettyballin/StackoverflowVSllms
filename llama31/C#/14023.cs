using System;\nusing System.Diagnostics;\nusing System.IO.Pipes;\nusing System.Windows.Forms;\n\npublic class TabProcess\n{\n    private string _pipeName;\n\n    public TabProcess(string pipeName)\n    {\n        _pipeName = pipeName;\n    }\n\n    public void Start()\n    {\n        using (NamedPipeServerStream pipeServer = new NamedPipeServerStream(_pipeName, PipeDirection.In))\n        {\n            pipeServer.WaitForConnection();\n\n            // Create a new form\n            Application.Run(new TabForm(pipeServer));\n        }\n    }\n}\n\npublic class TabForm : Form\n{\n    private NamedPipeServerStream _pipeServer;\n\n    public TabForm(NamedPipeServerStream pipeServer)\n    {\n        _pipeServer = pipeServer;\n    }\n\n    protected override void OnLoad(EventArgs e)\n    {\n        base.OnLoad(e);\n\n        // Read data from the pipe\n        using (StreamReader reader = new StreamReader(_pipeServer))\n        {\n            string data = reader.ReadToEnd();\n\n            // Process the data\n        }\n    }\n}\n\npublic class ContainerApp\n{\n    public void CreateTab()\n    {\n        string pipeName = Guid.NewGuid().ToString();\n\n        // Create a new process for the tab\n        using (Process process = new Process())\n        {\n            process.StartInfo.FileName = "YourApp.exe";\n            process.StartInfo.Arguments = pipeName;\n            process.Start();\n        }\n\n        // Create a new named pipe\n        using (NamedPipeClientStream pipeClient = new NamedPipeClientStream(".", pipeName, PipeDirection.Out))\n        {\n            pipeClient.Connect();\n\n            // Send data to the new process\n            using (StreamWriter writer = new StreamWriter(pipeClient))\n            {\n                writer.Write("Hello, world!");\n            }\n        }\n    }\n}