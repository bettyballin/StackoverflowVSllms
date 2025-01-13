Bitmap b = this.TableListBMP;\nBitmapData bmpData = b.LockBits(new Rectangle(0, 0, b.Width, b.Height),\n                                ImageLockMode.ReadWrite, \n                                PixelFormat.Format32bppPArgb);\n\nint stride = bmpData.Stride;\nIntPtr Scan0 = bmpData.Scan0;\n\nunsafe\n{\n    byte* p = (byte*)(void*)Scan0;\n    \n    for (int y = 0; y < b.Height; ++y)\n    {\n        for (int x = 0; x < b.Width; ++x)\n        {\n            byte blue = p[(y * stride) + (x * 4)];\n            byte green = p[(y * stride) + (x * 4) + 1];\n            byte red = p[(y * stride) + (x * 4) + 2];\n            byte alpha = p[(y * stride) + (x * 4) + 3];\n\n            if (red == 0 && green == 0 && blue == 0)\n            {\n                MessageBox.Show(\n                    string.Format("x={0}, y={1}, ARGB={2},{3},{4},{5}",\n                    x, y, alpha, red, green, blue));\n            }\n        }\n    }\n}\nb.UnlockBits(bmpData);