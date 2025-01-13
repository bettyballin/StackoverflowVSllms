BitmapData srcData = bm.LockBits(\n            new Rectangle(0, 0, bm.Width, bm.Height), \n            ImageLockMode.ReadOnly, \n            PixelFormat.Format32bppArgb);\n\nint stride = srcData.Stride;\n\nIntPtr Scan0 = srcData.Scan0;\n\nlong[] totals = new long[] {0,0,0};\n\nint width = bm.Width;\nint height = bm.Height;\n\nunsafe\n{\n  byte* p = (byte*) (void*) Scan0;\n\n  for (int y = 0; y < height; y++)\n  {\n    for (int x = 0; x < width; x++)\n    {\n      for (int color = 0; color < 3; color++)\n      {\n        int idx = (y*stride) + x*4 + color;\n\n        totals[color] += p[idx];\n      }\n    }\n  }\n}\n\nint avgB = totals[0] / (width*height);\nint avgG = totals[1] / (width*height);\nint avgR = totals[2] / (width*height);