using System.Drawing;\nusing System.Drawing.Drawing2D;\n\n// Load the image\nBitmap image = new Bitmap("input.png");\n\n// Define the transformation matrix\nMatrix transform = new Matrix();\ntransform.Translate(0, -100); // move top-left corner up by 100 pixels\ntransform.Scale(1.5f, 1.0f); // resize image\n\n// Apply the transformation\nGraphics graphics = Graphics.FromImage(image);\ngraphics.Transform = transform;\ngraphics.DrawImage(image, 0, 0);\n\n// Save the transformed image\nimage.Save("output.png");