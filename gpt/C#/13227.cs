using System;\nusing System.Windows.Forms;\n\npublic class YourMainForm : Form\n{\n    private const int WM_SHOWFORM = 0x0401;\n\n    public YourMainForm()\n    {\n        this.Text = "YourMainFormTitle";\n    }\n\n    protected override void WndProc(ref Message m)\n    {\n        if (m.Msg == WM_SHOWFORM)\n        {\n            this.Show();\n            this.WindowState = FormWindowState.Normal;\n            this.BringToFront();\n        }\n        base.WndProc(ref m);\n    }\n}