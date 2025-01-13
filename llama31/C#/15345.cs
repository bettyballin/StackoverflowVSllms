List<Rectangle> rectangles = new List<Rectangle>\n{\n    new Rectangle { X0 = 0.1, Y0 = 0.1, X1 = 0.3, Y1 = 0.3 },\n    new Rectangle { X0 = 0.2, Y0 = 0.2, X1 = 0.4, Y1 = 0.4 },\n    new Rectangle { X0 = 0.3, Y0 = 0.3, X1 = 0.5, Y1 = 0.5 },\n};\n\ndouble overlapArea = RectangleOverlapDetector.CalculateOverlapArea(rectangles);\nConsole.WriteLine("Overlap area: " + overlapArea);