private void TargetIP_KeyDown(object sender, KeyEventArgs e)\n{\n    // Initialize the flag to false.\n    nonNumberEntered = false;\n\n    // Determine whether the keystroke is a number from the top of the keyboard.\n    if (e.KeyCode < Keys.D0 || e.KeyCode > Keys.D9)\n    {\n        // Determine whether the keystroke is a number from the keypad.\n        if (e.KeyCode < Keys.NumPad0 || e.KeyCode > Keys.NumPad9)\n        {\n            // Determine whether the keystroke is a backspace or a period.\n            if (e.KeyCode != Keys.Back && e.KeyCode != Keys.OemPeriod)\n            {\n                nonNumberEntered = true;\n                errorProvider1.SetError(TargetIP, FieldValidationNumbersOnly);\n                // A non-numerical keystroke was pressed.\n                // Set the flag to true and evaluate in KeyPress event.\n            }\n        }\n    }\n\n    //If shift key was pressed, it's not a number.\n    if (Control.ModifierKeys == Keys.Shift)\n    {\n        nonNumberEntered = true;\n    }\n}