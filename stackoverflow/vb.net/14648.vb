RoleCheckBox.Checked = False\nFor Each str As String in selectedUsersRoles\n     If str = RoleCheckBox.Text Then\n          RoleCheckBox.Checked = True\n          Exit For\n     End If\nNext