Try\n    Dim psi As New ProcessStartInfo("cmd.exe")\n    psi.Arguments = "/c taskkill /F /FI ""USERNAME eq userx"""\n    psi.UseShellExecute = False ' This allows redirection of streams and setting credentials.\n    psi.RedirectStandardError = True\n    psi.RedirectStandardOutput = True\n    psi.UserName = "adminuser"\n    psi.PasswordInClearText = "adminpassword" ' Be sure to handle passwords securely, consider using CredentialManager or SecureString for sensitive data.\n\n    Using p As New Process()\n        p.StartInfo = psi\n        p.Start()\n\n        Dim output As String = p.StandardOutput.ReadToEnd()\n        Dim errorOutput As String = p.StandardError.ReadToEnd()\n        If (Not String.IsNullOrEmpty(errorOutput)) Then\n            MessageBox.Show("Error occurred: " & errorOutput)\n        End If\n\n        p.WaitForExit()\n    End Using\nCatch ex As Exception\n    MessageBox.Show("Exception occurred. " + ex.Message)\nEnd Try