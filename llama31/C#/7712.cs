private void Label_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)\n{\n    Label label = (Label)sender;\n    Point point = label.PointToScreen(new Point(0, 0));\n    // point now contains the top/left position of the label relative to the screen\n}