ErrorProvider errorProvider = new ErrorProvider();\n\n    private void ValidateInput()\n    {\n        if (string.IsNullOrEmpty(textBoxName.Text))\n        {\n            errorProvider.SetError(textBoxName, "Name is required.");\n        }\n        else\n        {\n            errorProvider.SetError(textBoxName, string.Empty);\n        }\n\n        // Repeat for other controls\n    }