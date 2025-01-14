' Sample For Text Box Validation (e.g., Not Null)\nPrivate Sub txtFieldName_AfterUpdate()\n    Dim errMsg As String\n    If Me.txtFieldName.Value = "" Then\n        errMsg = "This field is required."\n        MsgBox errs, vbExclamation, "Validation Error"\n        Me.txtFieldName.SetFocus\n        Cancel = True  ' Prevents loss of focus till validation passes\n    End If\nEnd Sub\n\n' Sample For Form Level Validation (e.g., cross-field validation)\nPrivate Sub Form_BeforeUpdate(Cancel As Integer)\n    Dim errMsg As String\n    If Not IsDate(Me.txtDateString.Value) Then\n        errMsg = "Please enter a valid date."\n        MsgBox errMsg, vbExclamation, "Validation Error"\n        Me.txtDateString.SetFocus\n        Cancel = True  ' Stops the form from being updated\n        Exit Sub\n    End If\n    \n    ' Additional validations can go here...\n    \n    ' Validation passed successfully\nEnd Sub\n\n' Custom Close Button Logic to Save Data Only If Validated\nPrivate Sub btnClose_Click()\n    On Error GoTo Err_CloseForm\n    DoCmd.RunCommand acCmdSaveRecord  ' Tries to save the record, which triggers validations\n    DoCmd.Close  ' Closes the form if all validations passed\n    \nExit_CloseForm:\n    Exit Sub\n\nErr_CloseForm:\n    MsgBox "Record cannot be saved due to validation errors.", vbCritical, "Error"\nEnd Sub