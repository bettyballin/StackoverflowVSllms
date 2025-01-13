using System;\nusing System.Diagnostics;\nusing System.Windows.Forms;\n\npublic class YourClass\n{\n    Process gameServerProcess;\n    ServerWindow window;\n\n    void StartServerProcess()\n    {\n        gameServerProcess = new Process();\n        gameServerProcess.StartInfo.UseShellExecute = false;\n        gameServerProcess.StartInfo.RedirectStandardOutput = true;\n        gameServerProcess.StartInfo.RedirectStandardError = true; // Also redirect standard error\n        gameServerProcess.StartInfo.RedirectStandardInput = true;\n        gameServerProcess.StartInfo.CreateNoWindow = true; // Ensure no window is created\n\n        gameServerProcess.EnableRaisingEvents = true;\n        gameServerProcess.Exited += new EventHandler(gameServer_WindowExit);\n\n        window = new ServerWindow();\n        gameServerProcess.OutputDataReceived += new DataReceivedEventHandler(window.server_recievedOutputStream);\n        gameServerProcess.ErrorDataReceived += new DataReceivedEventHandler(window.server_recievedOutputStream); // Handle error stream\n\n        window.Show();\n\n        gameServerProcess.StartInfo.FileName = @"D:\Program Files\Java\jdk1.6.0_12\bin\java.exe";\n        gameServerProcess.StartInfo.WorkingDirectory = @"D:\Users\Zack\Desktop\ServerFiles\gameserver";\n        gameServerProcess.StartInfo.Arguments = @"-Xmx1024m -cp ./../libs/*;l2jserver.jar net.sf.l2j.gameserver.GameServer";\n        gameServerProcess.Start();\n\n        gameServerProcess.BeginOutputReadLine(); // Begin async read of output\n        gameServerProcess.BeginErrorReadLine(); // Begin async read of error\n    }\n\n    void gameServer_WindowExit(object sender, EventArgs e)\n    {\n        // Handle the process exit event\n    }\n}\n\npublic class ServerWindow : Form\n{\n    private delegate void WriteOutputDelegate(string output);\n    private WriteOutputDelegate writeOutput;\n    private TextBox logBox;\n\n    public ServerWindow()\n    {\n        InitializeComponent();\n        logBox.BackColor = Color.White;\n        logBox.ForeColor = Color.Black;\n        writeOutput = new WriteOutputDelegate(write);\n    }\n\n    public void server_recievedOutputStream(object sender, DataReceivedEventArgs args)\n    {\n        if (args.Data != null)\n        {\n            BeginInvoke(writeOutput, new object[] { args.Data });\n        }\n    }\n\n    private void write(string output)\n    {\n        logBox.AppendText(output + Environment.NewLine);\n    }\n\n    private void InitializeComponent()\n    {\n        this.logBox = new System.Windows.Forms.TextBox();\n        this.SuspendLayout();\n        // \n        // logBox\n        // \n        this.logBox.Location = new System.Drawing.Point(12, 12);\n        this.logBox.Multiline = true;\n        this.logBox.Name = "logBox";\n        this.logBox.Size = new System.Drawing.Size(776, 426);\n        this.logBox.TabIndex = 0;\n        // \n        // ServerWindow\n        // \n        this.ClientSize = new System.Drawing.Size(800, 450);\n        this.Controls.Add(this.logBox);\n        this.Name = "ServerWindow";\n        this.ResumeLayout(false);\n        this.PerformLayout();\n    }\n}