protected void Button1_Click(object sender, EventArgs e)\n{\n    Label1.Text = "Processing...";\n    UpdatePanel1.Update(); // Manually trigger update\n\n    // Simulate some processing\n    System.Threading.Thread.Sleep(1000); // Replace with actual method call\n\n    Label1.Text = "Done.";\n    Label2.Text = "Processing...";\n    UpdatePanel1.Update(); // Manually trigger update\n\n    // Simulate some processing\n    System.Threading.Thread.Sleep(1000); // Replace with actual method call\n\n    Label2.Text = "Done.";\n    UpdatePanel1.Update(); // Manually trigger update\n}