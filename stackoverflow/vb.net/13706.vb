Dim objMail\n\nSet objMail = CreateObject("CDO.Message")\n\nobjMail.From = "Me <Me@Server.com>"\nobjMail.To = "You <You@AnotherServer.com>"\nobjMail.Subject = "That's a mail"\nobjMail.Textbody = "Hello World"\nobjMail.AddAttachment "C:\someFile.ext"\n\n---8<----- You don't need this part if you have an active Outlook [Express] account -----\n' Use an SMTP server\nobjMail.Configuration.Fields.Item _\n    ("http://schemas.microsoft.com/cdo/configuration/sendusing") = 2\n\n' Name or IP of Remote SMTP Server\nobjMail.Configuration.Fields.Item _\n    ("http://schemas.microsoft.com/cdo/configuration/smtpserver") = _\n    "smtp.server.com"\n\n' Server port (typically 25)\nobjMail.Configuration.Fields.Item _\n    ("http://schemas.microsoft.com/cdo/configuration/smtpserverport") = 25\n\nobjMail.Configuration.Fields.Update\n----- End of SMTP usage ----->8---\n\nobjMail.Send\n\nSet objMail=Nothing\nWscript.Quit