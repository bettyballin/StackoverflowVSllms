Sub SendMessage()\n    Dim olApp As Outlook.Application\n    Dim olNS As Outlook.Namespace\n    Dim olMail As Outlook.MailItem\n\n    Set olApp = Outlook.Application\n    Set olNS = olApp.GetNamespace("MAPI")\n    Set olMail = olApp.CreateItem(olMailItem)\n\n    olMail.Subject = "Test Subject"\n    olMail.Body = "This is a test message."\n    olMail.To = "recipient@example.com"\n    olMail.Send\nEnd Sub