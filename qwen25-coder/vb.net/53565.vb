Sub SendEmailSMTP()\n    Dim objOutlook As Object\n    Set objOutlook = CreateObject(" Outlook.Application")\n    \n    ' Configure the mail item\n    With objOutlook.CreateItem(0)\n        .To = "email@address.com"\n        .Subject = "Helpdesk Submission"\n        .Body = msg\n        .Send       ' Use .Display for testing to see the email before sending\n    End With\n    \n    Set objOutlook = Nothing\nEnd Sub