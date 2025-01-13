protected void btnAddUserToRole_Click(object sender, EventArgs e)\n{\n    if (!Roles.IsUserInRole(txtUserName.Text, ddlRoles.SelectedValue))\n    {\n        Roles.AddUserToRole(txtUserName.Text, ddlRoles.SelectedValue);\n        lblMessage.Text = "User added to the role successfully.";\n    }\n    else\n    {\n        lblMessage.Text = "This user is already in this role!";\n    }\n}