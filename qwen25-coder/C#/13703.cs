private void txtBox1_TextChanged(object sender, EventArgs e)\n{\n    btnSubmit1.Focus();\n}\n\nprivate void txtBox2_TextChanged(object sender, EventArgs e)\n{\n    btnSubmit2.Focus();\n}\n\nprivate void txtBox3_TextChanged(object sender, EventArgs e)\n{\n    btnSubmit3.Focus();\n}\n\nprivate void HandleEnterKeyPress(object sender, KeyEventArgs e)\n{\n    if (e.KeyCode == Keys.Enter)\n    {\n        if (txtBox1.Focused)\n        {\n            btnSubmit1.PerformClick();\n        }\n        else if (txtBox2.Focused)\n        {\n            btnSubmit2.PerformClick();\n        }\n        else if (txtBox3.Focused)\n        {\n            btnSubmit3.PerformClick();\n        }\n    }\n}\n\n// Attach the KeyDown event handler to all textboxes\nprivate void Form1_Load(object sender, EventArgs e)\n{\n    txtBox1.KeyDown += HandleEnterKeyPress;\n    txtBox2.KeyDown += HandleEnterKeyPress;\n    txtBox3.KeyDown += HandleEnterKeyPress;\n}