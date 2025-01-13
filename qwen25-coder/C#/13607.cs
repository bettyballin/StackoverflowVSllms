using System;\nusing System.Windows.Forms;\n\npublic class NotifyIconManager\n{\n    private NotifyIcon notifyIcon;\n    private bool balloonVisible = false;\n\n    public NotifyIconManager()\n    {\n        InitializeNotifyIcon();\n    }\n\n    private void InitializeNotifyIcon()\n    {\n        notifyIcon = new NotifyIcon();\n        notifyIcon.Text = "My Application";\n        notifyIcon.Icon = SystemIcons.Application;\n        notifyIcon.Visible = true;\n\n        // Set up context menu\n        ContextMenu contextMenu = new ContextMenu();\n        MenuItem menuItem1 = new MenuItem("Open", OnContextMenuClick);\n        contextMenu.MenuItems.Add(menuItem1);\n\n        // Subscribe to events\n        notifyIcon.BalloonTipClosed += OnBalloonTipClosed;\n        notifyIcon.ContextMenu = contextMenu;\n\n        // Add a sample notification queue handling\n        Notify("First Notification");\n    }\n\n    private void Notify(string message)\n    {\n        if (!balloonVisible)\n        {\n            balloonVisible = true;\n            notifyIcon.ShowBalloonTip(5000, "My Application", message, ToolTipIcon.Info);\n        }\n    }\n\n    private void OnBalloonTipClosed(object sender, EventArgs e)\n    {\n        balloonVisible = false;\n\n        // Check if another notification needs to be shown\n        // Notify("Next Notification");\n    }\n\n    private void OnContextMenuClick(object sender, EventArgs e)\n    {\n        // When context menu is clicked, the balloon might close, so we manually reset the state\n        balloonVisible = false;\n    }\n}