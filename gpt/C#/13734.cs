private void btnUpdate_Click(object sender, EventArgs e)\n{\n    if (_personInfo.Tables.Count > 0 && _personInfo.Tables[0].Rows.Count > 0)\n    {\n        DataRow personRow = _personInfo.Tables[0].Rows[0];\n        personRow["Name"] = txtName.Text;\n        personRow["Email"] = txtEmail.Text;\n        // Update other fields similarly...\n\n        if (_personInfo.HasChanges())\n        {\n            var whatChanged = _personInfo.GetChanges();\n            var confirmChanges = MessageBox.Show(\n                "Are you sure you want to make these changes?", \n                "Confirm Member Info Changes", \n                MessageBoxButtons.YesNo, \n                MessageBoxIcon.Question);\n\n            if (confirmChanges == DialogResult.Yes)\n            {\n                // Apply changes to the DataSet\n                _personInfo.AcceptChanges();\n                // Save changes back to the database\n                ConnectBLL.BLL.Person.Update(_personInfo);\n            }\n        }\n    }\n}