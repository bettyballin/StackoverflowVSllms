using System.Drawing;\n\n// ...\n\nFont font = new Font("Arial", 12);\nstring text = "Hello, World!";\nSizeF size = font.MeasureString(text);\n\n// Use the size to calculate the bounding rectangle\nRectangleF boundingRect = new RectangleF(0, 0, size.Width, size.Height);