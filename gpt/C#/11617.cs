using System;\nusing System.Drawing;\nusing System.Windows.Forms;\n\npublic class DrawingForm : Form\n{\n    private Bitmap drawingBitmap;\n\n    public DrawingForm()\n    {\n        this.Width = 800;\n        this.Height = 800;\n        this.Paint += new PaintEventHandler(this.Form_Paint);\n        this.Load += new EventHandler(this.Form_Load);\n\n        this.drawingBitmap = new Bitmap(800, 800);\n        DrawLines();\n    }\n\n    private void Form_Load(object sender, EventArgs e)\n    {\n        this.DoubleBuffered = true; // Helps reduce flicker\n    }\n\n    private void Form_Paint(object sender, PaintEventArgs e)\n    {\n        e.Graphics.DrawImage(this.drawingBitmap, 0, 0);\n    }\n\n    private void DrawLines()\n    {\n        Random random = new Random();\n        using (Graphics g = Graphics.FromImage(this.drawingBitmap))\n        {\n            g.Clear(Color.White); // Clear the bitmap with a white background\n            Pen pen = new Pen(Color.Black);\n\n            for (int i = 0; i < 100; i++)\n            {\n                Point p1 = new Point(random.Next(800), random.Next(800));\n                Point p2 = new Point(random.Next(800), random.Next(800));\n                g.DrawLine(pen, p1, p2);\n            }\n        }\n    }\n\n    [STAThread]\n    static void Main()\n    {\n        Application.EnableVisualStyles();\n        Application.Run(new DrawingForm());\n    }\n}