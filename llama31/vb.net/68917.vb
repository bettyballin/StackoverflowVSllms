Dim listBox1 As New ListBox()\nDim listBox2 As New ListBox()\n\n' Synchronize data and properties\nlistBox2.DataSource = listBox1.DataSource\nlistBox2.DisplayMember = listBox1.DisplayMember\nlistBox2.ValueMember = listBox1.ValueMember