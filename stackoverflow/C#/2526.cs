//Value of red divided by average of blue and green:\nPixel pixel = image.getPixel(x,y);\nfloat redIntensity = ((float)pixel.R / ((pixel.G + pixel.B) / 2));\nif (redIntensity > 1.5f)  // 1.5 because it gives the best results\n{\n    // reduce red to the average of blue and green\n    bm.SetPixel(i, j, Color.FromArgb((pixel.G + pixel.B) / 2, pixel.G, pixel.B));\n}