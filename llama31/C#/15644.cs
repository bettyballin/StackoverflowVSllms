private void pictureBox1_MouseDown(object sender, MouseEventArgs e)\n{\n    btn.Image = Properties.Resources.buttonpressedimage;\n    btn.FlatStyle = FlatStyle.Flat;\n    btn.FlatAppearance.BorderSize = 0;\n    btn.FlatAppearance.BorderColor = Color.FromArgb(0, 255, 255, 255); // transparent\n    btn.Location = new Point(btn.Location.X + 2, btn.Location.Y + 2);\n}\n\nprivate void pictureBox1_MouseUp(object sender, MouseEventArgs e)\n{\n    btn.Image = Properties.Resources.buttonnormalimage;\n    btn.FlatStyle = FlatStyle.Standard;\n    btn.Location = new Point(btn.Location.X - 2, btn.Location.Y - 2);\n}