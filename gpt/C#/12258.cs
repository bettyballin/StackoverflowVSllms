using System;\nusing System.Windows.Forms;\n\npublic class MyForm : Form\n{\n    private static MyForm instance;\n\n    private MyForm()\n    {\n        // Initialize your form here\n    }\n\n    public static MyForm GetInstance()\n    {\n        if (instance == null || instance.IsDisposed)\n        {\n            instance = new MyForm();\n        }\n        return instance;\n    }\n\n    public static bool IsFormOpen()\n    {\n        return instance != null && !instance.IsDisposed;\n    }\n}\n\n// Usage in your application\npublic class Program\n{\n    [STAThread]\n    static void Main()\n    {\n        Application.EnableVisualStyles();\n        Application.SetCompatibleTextRenderingDefault(false);\n\n        // Check if the form is already open\n        if (!MyForm.IsFormOpen())\n        {\n            MyForm form = MyForm.GetInstance();\n            form.Show();\n        }\n        else\n        {\n            MessageBox.Show("MyForm is already open.");\n        }\n\n        Application.Run();\n    }\n}