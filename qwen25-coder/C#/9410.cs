private void Form1_KeyDown(object sender, KeyEventArgs e)\n{\n    if (e.KeyCode == Keys.A)\n    {\n        Console.WriteLine("A key was pressed down");\n    }\n}\n\nprivate void Form1_KeyUp(object sender, KeyEventArgs e)\n{\n    if (e.KeyCode == Keys.A)\n    {\n        Console.WriteLine("A key was released");\n    }\n}