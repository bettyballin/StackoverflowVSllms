protected void btnChangeText_Click(object sender, EventArgs e)\n{\n    string script = "document.getElementById('myRadioButton').nextSibling.textContent='New Text';";\n    ClientScript.RegisterStartupScript(this.GetType(), "changeText", script, true);\n}