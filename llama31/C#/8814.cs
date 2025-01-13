using System;\nusing System.Threading;\nusing System.Diagnostics;\n\npublic class MyForm : Form\n{\n    private static Semaphore _semaphore;\n    private static string _processId;\n\n    public MyForm()\n    {\n        _processId = Process.GetCurrentProcess().Id.ToString();\n        _semaphore = new Semaphore(1, 1, "MyForm_" + _processId);\n    }\n\n    public void ShowForm()\n    {\n        if (_semaphore.WaitOne(TimeSpan.Zero, false))\n        {\n            try\n            {\n                Show();\n            }\n            finally\n            {\n                _semaphore.Release();\n            }\n        }\n        else\n        {\n            // An instance of MyForm is already running for this process\n        }\n    }\n}