// MainApplication -> Program.cs\nusing System;\nusing System.Windows.Forms;\nusing ClassLibraryProject;\n\nnamespace MainApplication\n{\n    static class Program\n    {\n        [STAThread]\n        static void Main()\n        {\n            Application.EnableVisualStyles();\n            Application.SetCompatibleTextRenderingDefault(false);\n            FormLauncher.ShowForm();\n        }\n    }\n}