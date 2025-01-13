private Point start;\nprivate bool isDragging = false;\n\nprivate void myGrid_MouseDown(object sender, MouseButtonEventArgs e)\n{\n    start = e.GetPosition(this);\n    isDragging = true;\n}\n\nprivate void myGrid_MouseMove(object sender, MouseEventArgs e)\n{\n    if (isDragging)\n    {\n        Point current = e.GetPosition(this);\n        myGrid.RenderTransform = new TranslateTransform(current.X - start.X, current.Y - start.Y);\n    }\n}