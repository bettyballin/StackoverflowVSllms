private void PrintButton_Click(object sender, RoutedEventArgs e)\n{\n    // ...\n    PrintDialog printDialog = new PrintDialog();\n    if (printDialog.ShowDialog() == true)\n    {\n        // Print the selected file using the chosen printer\n        // ...\n    }\n}