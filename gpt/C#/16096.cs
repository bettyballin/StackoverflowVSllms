if (!DateTime.TryParse(startDateTextBox.Text, out DateTime parsedDate))\n{\n    startDateTextBox.Text = DateTime.Today.ToShortDateString();\n}