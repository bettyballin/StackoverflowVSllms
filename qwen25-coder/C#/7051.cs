public partial class MainForm : Form\n{\n    public MainForm()\n    {\n        InitializeComponent();\n        this.MdiChildActivate += new EventHandler(MainForm_MdiChildActivate);\n    }\n\n    private void MainForm_MdiChildActivate(object sender, EventArgs e)\n    {\n        // Check if there is an active MDI child\n        Form activeChild = this.ActiveMdiChild;\n        if (activeChild != null)\n        {\n            // Ensure the form is within visible bounds of the MDI parent's desktop area\n            Rectangle clientRectangle = this.DesktopBounds;\n\n            // Adjust X position\n            if (activeChild.Left < 0)\n                activeChild.Left = 0;\n            else if ((activeChild.Right - clientRectangle.Width) > 0)\n                activeChild.Left = clientRectangle.Width - activeChild.Width;\n\n            // Adjust Y position\n            if (activeChild.Top < 0)\n                activeChild.Top = 0;\n            else if ((activeChild.Bottom - clientRectangle.Height) > 0)\n                activeChild.Top = clientRectangle.Height - activeChild.Height;\n        }\n    }\n}