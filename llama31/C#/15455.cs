using System;\nusing System.Diagnostics;\nusing System.Runtime.InteropServices;\nusing System.Windows.Forms;\n\npublic partial class Form1 : Form\n{\n    [DllImport("user32.dll")]\n    private static extern IntPtr SetParent(IntPtr hWndChild, IntPtr hWndNewParent);\n\n    private Process _process;\n\n    public Form1()\n    {\n        InitializeComponent();\n    }\n\n    private void button1_Click(object sender, EventArgs e)\n    {\n        _process = new Process();\n        _process.StartInfo.FileName = "notepad.exe"; // Replace with your application's path\n        _process.Start();\n\n        // Wait for the process to start\n        while (_process.MainWindowHandle == IntPtr.Zero)\n        {\n            Application.DoEvents();\n        }\n\n        // Set the parent window\n        SetParent(_process.MainWindowHandle, this.Handle);\n    }\n}