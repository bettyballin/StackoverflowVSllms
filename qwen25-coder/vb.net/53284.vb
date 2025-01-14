Imports System.Net\nImports System.Net.Mail\n\nModule Module1\n    Sub Main()\n        Dim from As String = "yourYahooEmail@yahoo.com"\n        Dim password As String = "yourYahooPassword"\n        Dim to As String = "recipientEmail@example.com"\n        Dim subject As String = "Test Subject"\n        Dim body As String = "Hello, this is a test email sent through Yahoo SMTP."\n\n        Dim mailMessage As New MailMessage(from, to, subject, body)\n\n        Using smtpClient As New SmtpClient("smtp.mail.yahoo.com", 587)\n            smtpClient.EnableSsl = True\n            smtpClient.Credentials = New NetworkCredential(from, password)\n            Try\n                smtpClient.Send(mailMessage)\n                Console.WriteLine("Email sent successfully!")\n            Catch ex As Exception\n                Console.WriteLine($"Failed to send email with the following error: {ex.Message}")\n            End Try\n        End Using\n    End Sub\nEnd Module