class Program\n{\n    [STAThread]\n    static void Main(string[] args)\n    {\n        Application app = new Application();\n        MyWindow window = new MyWindow();\n        app.Run(window);\n    }\n}