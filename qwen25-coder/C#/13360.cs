private void button1_Click(object sender, EventArgs e)\n{\n    if (shadowForm.Visible) { shadowForm.Hide(); }\n    else\n    {\n        // Force form to re-layout its child controls, etc.\n        this.Update();\n\n        shadowForm.Size = Size; \n        shadowForm.Location = Location;\n       shadowForm.Show();\n    }\n}