private void Label_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)\n{\n    Label label = (Label)sender;\n    Point point = label.TranslatePoint(new Point(0, 0), flowLayoutPanel);\n    // point now contains the top/left position of the label relative to the flowLayoutPanel\n}