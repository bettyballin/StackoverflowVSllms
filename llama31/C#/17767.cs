private void BindComboBox()\n{\n    comboBox1.DataSource = users; // assuming 'users' is a list of User objects\n    comboBox1.DisplayMember = "Username";\n}