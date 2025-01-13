private AssociateForm associateForm = new AssociateForm();\n\nprivate void NotifyIcon1_MouseClick(object sender, MouseEventArgs e)\n{\n    if (e.Button == MouseButtons.Left)\n    {\n        if (associateForm.WindowState == FormWindowState.Normal && associateForm.Visible == true)\n        {\n            associateForm.WindowState = FormWindowState.Minimized;\n        }\n        else\n        {\n            associateForm.WindowState = FormWindowState.Normal;\n        }\n\n        associateForm.Show();\n        associateForm.Focus();\n        // bring to front of other windows\n        associateForm.Activate();\n    }\n}