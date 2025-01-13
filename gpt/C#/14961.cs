protected void cvSumValidator_ServerValidate(object source, ServerValidateEventArgs args)\n{\n    float input1, input2;\n    if (float.TryParse(txtInput1.Text, out input1) && float.TryParse(txtInput2.Text, out input2))\n    {\n        if (input1 + input2 > 100)\n        {\n            args.IsValid = false;\n        }\n        else\n        {\n            args.IsValid = true;\n        }\n    }\n    else\n    {\n        args.IsValid = false;\n    }\n}\n\nprotected void btnSubmit_Click(object sender, EventArgs e)\n{\n    if (Page.IsValid)\n    {\n        // Handle the valid submission logic here.\n    }\n}