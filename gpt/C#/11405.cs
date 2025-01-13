<asp:TextBox ID="MyTextBox" runat="server" \n             Text='<%# Bind("MyValue") %>' AutoPostBack="True" \n             OnTextChanged="MyTextBox_TextChanged" />\n\nprotected void MyTextBox_TextChanged(object sender, EventArgs e)\n{\n    TextBox textBox = sender as TextBox;\n    if (textBox != null)\n    {\n        string input = textBox.Text;\n        decimal? value = ConvertToNullableDecimal(input);\n        \n        // Assuming MyFormView is your FormView control\n        FormViewItem item = MyFormView.FindControl("MyValue") as FormViewItem;\n        if (item != null)\n        {\n            item.Value = value;\n        }\n    }\n\n    MyFormView.UpdateItem(false);\n}\n\nprivate decimal? ConvertToNullableDecimal(string input)\n{\n    decimal result;\n    if (decimal.TryParse(input, out result))\n    {\n        return result;\n    }\n    return null;\n}