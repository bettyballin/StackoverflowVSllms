public class MyClass\n{\n    private Form _form;\n\n    public void InitializeForm()\n    {\n        Application.SetCompatibleTextRenderingDefault(false);\n        _form = new MyForm();\n    }\n\n    public void ShowForm()\n    {\n        _form.Show();\n    }\n}