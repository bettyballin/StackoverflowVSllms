private void TargetIP_TextChanged(object sender, EventArgs e)\n{\n    string ipAddress = TargetIP.Text;\n    string pattern = @"^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";\n\n    if (!Regex.IsMatch(ipAddress, pattern))\n    {\n        errorProvider1.SetError(TargetIP, "Invalid IP address");\n    }\n    else\n    {\n        errorProvider1.Clear();\n    }\n}