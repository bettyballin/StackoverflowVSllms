Dim columnName As String\n\nPrivate Sub Report_Open(Cancel As Integer)\n    columnName = "January" ' or any other column name\nEnd Sub\n\n' in the text box control's Control Source property:\n=[qryCrosstab].[columnName]