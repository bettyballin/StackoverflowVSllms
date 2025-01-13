using System;\nusing System.Drawing;\nusing System.Windows.Forms;\n\npublic class RotatedLabel : Label\n{\n    protected override void OnPaint(PaintEventArgs e)\n    {\n        e.Graphics.TranslateTransform(Width, Height);\n        e.Graphics.RotateTransform(-90);\n        base.OnPaint(e);\n    }\n\n    protected override void OnPaintBackground(PaintEventArgs e)\n    {\n        // Do not call base.OnPaintBackground to prevent flickering\n    }\n}\n\n// Usage example in a Form\npublic class MainForm : Form\n{\n    public MainForm()\n    {\n        var rotatedLabel = new RotatedLabel\n        {\n            Text = "Rotated Label",\n            Size = new Size(100, 30),\n            Location = new Point(50, 50)\n        };\n\n        Controls.Add(rotatedLabel);\n    }\n\n    [STAThread]\n    public static void Main()\n    {\n        Application.EnableVisualStyles();\n        Application.SetCompatibleTextRenderingDefault(false);\n        Application.Run(new MainForm());\n    }\n}