using System;\nusing System.Windows.Forms;\n\npublic class NotificationApp\n{\n    public static void Main()\n    {\n        NotifyIcon notifyIcon = new NotifyIcon();\n        notifyIcon.Icon = SystemIcons.Information; // Use a built-in icon for simplicity\n        notifyIcon.Visible = true;\n\n        notifyIcon.BalloonTipTitle = "Notification Title";\n        notifyIcon.BalloonTipText = "This is a sample notification message.";\n        notifyIcon.BalloonTipIcon = ToolTipIcon.Info;\n\n        notifyIcon.ShowBalloonTip(3000); // Show the balloon tip for 3 seconds\n\n        Application.Run(); // Keep the application running to display the notification\n    }\n}