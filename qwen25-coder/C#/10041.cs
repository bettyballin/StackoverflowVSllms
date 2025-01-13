using System;\nusing System.Diagnostics;\nusing System.Windows.Forms;\n\npublic partial class MainForm : Form\n{\n    private Process process;\n\n    public MainForm()\n    {\n        InitializeComponent();\n        StartProcess();\n    }\n\n    private void StartProcess()\n    {\n        try\n        {\n            process = new Process();\n            var path = @"C:\ConsoleApp.exe";\n\n            process.StartInfo.FileName = path;\n            process.StartInfo.UseShellExecute = false;\n            process.StartInfo.RedirectStandardOutput = true;\n\n            // Redirect the output to the event handler.\n            process.OutputDataReceived += P_OutputDataReceived;\n\n            process.Start();\n\n            // Begin asynchronous read of the output stream.\n            process.BeginOutputReadLine();\n        }\n        catch (Exception ex)\n        {\n            MessageBox.Show("Error starting process: " + ex.Message);\n        }\n    }\n\n    private void P_OutputDataReceived(object sender, DataReceivedEventArgs e)\n    {\n        if (!string.IsNullOrEmpty(e.Data))\n        {\n            // Update the TextBox with new data\n            textBoxOutput.Invoke(new Action(() =>\n            {\n                textBoxOutput.AppendText(e.Data + Environment.NewLine);\n            }));\n        }\n    }\n}