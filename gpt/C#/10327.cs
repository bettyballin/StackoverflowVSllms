private void OnOkButtonClick(object sender, RoutedEventArgs e)\n{\n    this.DialogResult = true;\n    this.Close();\n}\n\nprivate void OnCancelButtonClick(object sender, RoutedEventArgs e)\n{\n    this.DialogResult = false;\n    this.Close();\n}