using System;\nusing System.Windows.Forms;\n\npublic class MyForm : Form\n{\n    public MyForm()\n    {\n        Text = "Hello, World!";\n    }\n\n    [STAThread]\n    public static void Main()\n    {\n        Application.Run(new MyForm());\n    }\n}