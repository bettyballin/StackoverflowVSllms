private void ScrollView_KeyDown(object sender, KeyEventArgs e)\n{\n    // Check if the pressed key is an arrow key\n    if (e.Key == Key.Up || e.Key == Key.Down || e.Key == Key.Left || e.Key == Key.Right)\n    {\n        // Handle your custom logic here\n        Console.WriteLine("Arrow key was pressed: " + e.Key);\n\n        // Mark the event as handled to prevent the ScrollViewer from scrolling\n        e.Handled = true;\n    }\n}