using System;\nusing System.Windows.Forms;\n\nstatic class Program\n{\n    [STAThread]\n    static void Main()\n    {\n        Application.EnableVisualStyles();\n        Application.SetCompatibleTextRenderingDefault(false);\n        Application.Run(new MainForm());\n    }\n}