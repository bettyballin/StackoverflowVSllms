Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click\n\n    // Create the listView\n    Dim lstView As New ListView()\n    lstView.Dock = DockStyle.Fill\n    lstView.Items.Add("item 1") //item added for test\n    lstView.Items.Add("item 2") //item added for test\n\n    // Create the new tab page\n    Dim tab As New TabPage("next tab")\n    tab.Controls.Add(lstView) // Add the listview to the tab page\n\n    // Add the tabpage to the existing TabCrontrol\n    Me.TabControl1.TabPages.Add(tab)\n\nEnd Sub