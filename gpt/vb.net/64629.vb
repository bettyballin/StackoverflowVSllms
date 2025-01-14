Imports System.IO\nImports System.Windows.Forms\n\nPublic Class Form1\n    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load\n        ' Initialize ListView control\n        Dim listView As New ListView()\n        listView.View = View.Details\n        listView.FullRowSelect = True\n        listView.GridLines = True\n        listView.Dock = DockStyle.Fill\n\n        ' Add columns to ListView\n        listView.Columns.Add("File Name", 150)\n        listView.Columns.Add("Size (KB)", 100)\n        listView.Columns.Add("Date Modified", 150)\n\n        ' Add the ListView control to the form\n        Me.Controls.Add(listView)\n\n        ' Populate ListView with files from a directory\n        Dim directoryPath As String = "C:\YourDirectoryPath"\n        If Directory.Exists(directoryPath) Then\n            Dim files As String() = Directory.GetFiles(directoryPath)\n            For Each file As String In files\n                Dim fileInfo As New FileInfo(file)\n                Dim listViewItem As New ListViewItem(fileInfo.Name)\n                listViewItem.SubItems.Add((fileInfo.Length / 1024).ToString("N2"))\n                listViewItem.SubItems.Add(fileInfo.LastWriteTime.ToString())\n                listView.Items.Add(listViewItem)\n            Next\n        Else\n            MessageBox.Show("Directory does not exist.")\n        End If\n    End Sub\nEnd Class