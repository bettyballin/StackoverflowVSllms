Dim objMessage\nSet objMessage = CreateObject("CDO.Message")\n\nobjMessage.To = "recipient@example.com"\nobjMessage.From = "sender@example.com"\nobjMessage.Subject = "Test email"\nobjMessage.TextBody = "This is a test email sent from a Windows script"\n\nobjMessage.Configuration.Fields.Item("http://schemas.microsoft.com/cdo/configuration/sendusing") = 2\nobjMessage.Configuration.Fields.Item("http://schemas.microsoft.com/cdo/configuration/smtpserver") = "your_exchange_server"\nobjMessage.Configuration.Fields.Update\n\nobjMessage.Send