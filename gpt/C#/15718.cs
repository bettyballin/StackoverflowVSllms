private void textBox1_KeyPress(object sender, KeyPressEventArgs e)\n{\n    // Check if the key pressed is a digit or a control key (e.g., backspace)\n    if (!char.IsDigit(e.KeyChar) && !char.IsControl(e.KeyChar))\n    {\n        e.Handled = true;\n    }\n}