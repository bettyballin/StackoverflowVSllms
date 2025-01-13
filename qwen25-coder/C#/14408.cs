Bitmap b = this.TableListBMP;\nBitmapData bmpData = b.LockBits(new Rectangle(0, 0, b.Width, b.Height),\n                                ImageLockMode.ReadWrite, \n                                PixelFormat.Format32bppPArgb);\n\nint stride = bmpData.Stride;\nIntPtr Scan0 = bmpData.Scan0;\n\nunsafe\n{\n    byte* p = (byte*)(void*)Scan0;  \n    for(int y = 5; y < b.Height; ++y)\n    {\n        for(int x = 1; x < b.Width; ++x)\n        {\n            int offset = (y * stride) + (x * 4);\n            MessageBox.Show(\n                string.Format("x={0}, y={1}, ARGB={2},{3},{4},{5}",\n                  x, y,\n                  p[offset],\n                  p[offset + 1],\n                  p[offset + 2],\n                  p[offset + 3]));\n        }\n    }\n}\nb.UnlockBits(bmpData);