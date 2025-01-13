using System;\nusing System.Net.Mail;\nusing System.Timers;\n\npublic class EmailSender\n{\n    private SmtpClient _smtpClient;\n    private Timer _timer;\n    private int _batchSize = 1000;\n    private int _ emailsSent = 0;\n\n    public EmailSender(string smtpServer, int port)\n    {\n        _smtpClient = new SmtpClient(smtpServer, port);\n    }\n\n    public void SendEmails(string[] emailList)\n    {\n        _timer = new Timer(1000); // 1 second interval\n        _timer.Elapsed += new ElapsedEventHandler(OnTimerElapsed);\n\n        for (int i = 0; i < emailList.Length; i += _batchSize)\n        {\n            string[] batch = new string[_batchSize];\n            Array.Copy(emailList, i, batch, 0, _batchSize);\n\n            foreach (string email in batch)\n            {\n                try\n                {\n                    _smtpClient.Send(new MailMessage("yourfromemail@example.com", email, "Subject", "Body"));\n                    _emailsSent++;\n                }\n                catch (SmtpException ex)\n                {\n                    // Log the error\n                    Console.WriteLine($"Error sending email {email}: {ex.Message}");\n\n                    // Pause sending for 30 seconds\n                    _timer.Interval = 30000;\n                    _timer.Start();\n                }\n            }\n        }\n    }\n\n    private void OnTimerElapsed(object source, ElapsedEventArgs e)\n    {\n        // Resume sending emails\n        _timer.Stop();\n        _timer.Interval = 1000; // Reset interval to 1 second\n    }\n}