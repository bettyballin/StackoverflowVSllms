string[] addresses = toNode.InnerText.Split(",");\nforeach(string textAddress in addresses)\n{\n    textAddress = address.Trim();\n    MailAddress address = new MailAddress(textAddress);\n    message.CompanyName = address.DisplayName;\n    message.CompanyEmail = address.Address;\n}