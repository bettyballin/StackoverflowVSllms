Dim cmd As ADODB.Command\nSet cmd = New ADODB.Command\n\ncmd.ActiveConnection = yourConnectionObject\ncmd.CommandText = "UPDATE [Progress] SET [Date] = ? WHERE [SomeColumn] = ?"\ncmd.CommandType = adCmdText\n\n' Add parameters\ncmd.Parameters.Append cmd.CreateParameter("", adDate, adParamInput, , CDate(formattedDate))\ncmd.Parameters.Append cmd.CreateParameter("", adVarChar, adParamInput, 50, someValue)\n\n' Execute the command\ncmd.Execute