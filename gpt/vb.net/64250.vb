Dim new_username As String = "your_input_string_here"\nDim index As Integer = new_username.IndexOf(" Joined ")\n\nIf index >= 0 Then\n    new_username = new_username.Substring(0, index)\nElse\n    ' Handle the case where " Joined " is not found\n    ' For example, you can leave new_username as it is or set it to an empty string\n    new_username = new_username\nEnd If