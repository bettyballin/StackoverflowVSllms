using System;\nusing System.ComponentModel;\nusing System.Drawing;\nusing System.Windows.Forms;\n\npublic class MyUserControl : UserControl\n{\n    private string property1;\n    private string property2;\n    private int property3;\n    private int property4;\n\n    [Browsable(true)]\n    [Category("Custom Properties")]\n    [Description("First String Property")]\n    public string Property1\n    {\n        get { return property1; }\n        set { property1 = value; Invalidate(); }\n    }\n\n    [Browsable(true)]\n    [Category("Custom Properties")]\n    [Description("Second String Property")]\n    public string Property2\n    {\n        get { return property2; }\n        set { property2 = value; Invalidate(); }\n    }\n\n    [Browsable(true)]\n    [Category("Custom Properties")]\n    [Description("First Integer Property")]\n    public int Property3\n    {\n        get { return property3; }\n        set { property3 = value; Invalidate(); }\n    }\n\n    [Browsable(true)]\n    [Category("Custom Properties")]\n    [Description("Second Integer Property")]\n    public int Property4\n    {\n        get { return property4; }\n        set { property4 = value; Invalidate(); }\n    }\n\n    protected override void OnPaint(PaintEventArgs e)\n    {\n        base.OnPaint(e);\n\n        if (this.DesignMode)\n        {\n            string displayText = $"Property1: {Property1}\nProperty2: {Property2}\nProperty3: {Property3}\nProperty4: {Property4}";\n\n            using (Font font = new Font("Arial", 10))\n            using (Brush brush = new SolidBrush(Color.Black))\n            {\n                e.Graphics.DrawString(displayText, font, brush, new PointF(10, 10));\n            }\n        }\n    }\n}