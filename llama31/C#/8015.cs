// Create a FlowLayoutPanel\nFlowLayoutPanel flowLayoutPanel = new FlowLayoutPanel();\nflowLayoutPanel.Dock = DockStyle.Fill;\nflowLayoutPanel.AutoScroll = true;\nflowLayoutPanel.FlowDirection = FlowDirection.TopDown;\n\n// Create a list of your user controls\nList<MyUserControl> userControls = new List<MyUserControl>();\n\n// Populate the list\nfor (int i = 0; i < 10; i++)\n{\n    MyUserControl userControl = new MyUserControl();\n    userControl.Data = "Item " + i; // Assuming you have a Data property\n    userControls.Add(userControl);\n}\n\n// Add the user controls to the FlowLayoutPanel\nforeach (MyUserControl userControl in userControls)\n{\n    flowLayoutPanel.Controls.Add(userControl);\n}\n\n// Add the FlowLayoutPanel to your form\nthis.Controls.Add(flowLayoutPanel);