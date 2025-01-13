using System;\nusing System.Drawing;\nusing System.Drawing.Drawing2D;\nusing System.Windows.Forms;\n\npublic class RoundedRect : Form\n{\n    private PictureBox pictureBox1;\n\n    public RoundedRect()\n    {\n        pictureBox1 = new PictureBox();\n        pictureBox1.Location = new Point(12, 12);\n        pictureBox1.Name = "pictureBox1";\n        pictureBox1.Size = new Size(200, 200);\n        pictureBox1.TabIndex = 0;\n        pictureBox1.TabStop = false;\n        this.Controls.Add(pictureBox1);\n\n        DrawRoundedRect();\n    }\n\n    private void DrawRoundedRect()\n    {\n        Bitmap img = new Bitmap(pictureBox1.Width, pictureBox1.Height);\n        Graphics g = Graphics.FromImage(img);\n        g.SmoothingMode = SmoothingMode.AntiAlias;\n        g.FillRoundedRectangle(new SolidBrush(Color.Red), 0, 0, pictureBox1.Width, pictureBox1.Height, 10);\n        pictureBox1.Image = img;\n    }\n}\n\npublic static class GraphicsExtensions\n{\n    public static void FillRoundedRectangle(this Graphics g, Brush brush, float x, float y, float width, float height, float radius)\n    {\n        RectangleF rect = new RectangleF(x, y, width, height);\n        using (GraphicsPath path = GetRoundedPath(rect, radius))\n        {\n            g.FillPath(brush, path);\n        }\n    }\n\n    private static GraphicsPath GetRoundedPath(RectangleF rect, float radius)\n    {\n        GraphicsPath path = new GraphicsPath();\n        path.StartFigure();\n        path.AddArc(rect.X, rect.Y, radius * 2, radius * 2, 180, 90);\n        path.AddArc(rect.Right - radius * 2, rect.Y, radius * 2, radius * 2, 270, 90);\n        path.AddArc(rect.Right - radius * 2, rect.Bottom - radius * 2, radius * 2, radius * 2, 0, 90);\n        path.AddArc(rect.X, rect.Bottom - radius * 2, radius * 2, radius * 2, 90, 90);\n        path.CloseFigure();\n        return path;\n    }\n}