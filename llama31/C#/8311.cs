// Populate combo box\nBV_LEMSHIPDataSet.tblLEMSCredentialsDataTable dtAvailableTechs = taLEMSCreds.GetDataByAvailableTechs(selectedSerial);\ndtAvailableTechs.Rows.Add(DBNull.Value, "<NONE>"); // Add a row with DBNull value\ncboTechNumber.DataSource = dtAvailableTechs;\n\n// Save back to DB\nobject lemsCredsID = cboTechNumber.SelectedValue;\nif (lemsCredsID == DBNull.Value)\n{\n    lemsCredsID = null;\n}\ntaDevice.UpdateQuery_Restage(lemsCredsID, selectedSerial);