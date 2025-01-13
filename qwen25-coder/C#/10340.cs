private void TextBox_PreviewTextInput(object sender, TextCompositionEventArgs e)\n{\n    // Allows letter and number only\n    e.Handled = !new Regex(@"[\x08\dA-Za-z]").IsMatch(e.Text); // \x08 allows backspace for editing\n}