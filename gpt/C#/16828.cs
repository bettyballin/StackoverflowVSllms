using System;\nusing System.Drawing;\nusing System.Windows.Forms;\n\npublic class GDIPlusForm : Form\n{\n    protected override void OnPaint(PaintEventArgs e)\n    {\n        Graphics g = e.Graphics;\n\n        // Example drawing\n        g.Clear(Color.White);\n        g.DrawEllipse(Pens.Black, new Rectangle(10, 10, 100, 100));\n        g.FillRectangle(Brushes.Blue, new Rectangle(120, 10, 100, 100));\n    }\n\n    [STAThread]\n    public static void Main()\n    {\n        Application.EnableVisualStyles();\n        Application.Run(new GDIPlusForm());\n    }\n}