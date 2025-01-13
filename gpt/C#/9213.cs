using System;\nusing System.Threading;\nusing System.Windows.Forms;\n\nclass Program\n{\n    static void Main()\n    {\n        Thread thread = new Thread(new ParameterizedThreadStart(MyFormThreadproc));\n        thread.SetApartmentState(ApartmentState.STA);\n        thread.Start();\n    }\n\n    private static void MyFormThreadproc(object o)\n    {\n        MyForm form = new MyForm();\n        Application.Run(form);\n    }\n}\n\npublic class MyForm : Form\n{\n    // Your form implementation\n}