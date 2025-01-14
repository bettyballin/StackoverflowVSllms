Public Class Form1\n\n    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load\n        ' Set the form's render style to system to make it look more like C++ applications\n        Application.EnableVisualStyles()\n        Me.MenuStrip1.Renderer = New ToolStripProfessionalRenderer(New CustomColorTable())\n\n        ' Adding items to MenuStrip programmatically\n        Dim fileMenuItem As New ToolStripMenuItem("File")\n        Dim editMenuItem As New ToolStripMenuItem("Edit")\n        Dim helpMenuItem As New ToolStripMenuItem("Help")\n\n        ' Adding sub-items\n        fileMenuItem.DropDownItems.Add("New", Nothing, AddressOf FileMenu_Click)\n        fileMenuItem.DropDownItems.Add("Open", Nothing, AddressOf FileMenu_Click)\n        fileMenuItem.DropDownItems.Add("Save", Nothing, AddressOf FileMenu_Click)\n        fileMenuItem.DropDownItems.Add("Exit", Nothing, AddressOf FileMenu_Click)\n\n        editMenuItem.DropDownItems.Add("Cut")\n        editMenuItem.DropDownItems.Add("Copy")\n        editMenuItem.DropDownItems.Add("Paste")\n\n        helpMenuItem.DropDownItems.Add("About")\n\n        ' Adding menu items to MenuStrip\n        Me.MenuStrip1.Items.Add(fileMenuItem)\n        Me.MenuStrip1.Items.Add(editMenuItem)\n        Me.MenuStrip1.Items.Add(helpMenuItem)\n    End Sub\n\n    Private Sub FileMenu_Click(sender As Object, e As EventArgs)\n        MessageBox.Show(String.Format("'{0}' clicked", CType(sender, ToolStripMenuItem).Text))\n    End Sub\nEnd Class\n\n' Custom color table to further customize the menu strip appearance\nPublic Class CustomColorTable\n    Inherits ProfessionalColors\n\n    Public Overrides ReadOnly Property MenuItemSelectedGradientBegin() As Color\n        Get\n            Return Color.LightBlue ' Change as appropriate\n        End Get\n    End Property\n\n    Public Overrides ReadOnly Property ToolStripDropDownBackground() As Color\n        Get\n            Return Color.Gray ' Change as appropriate\n        End Get\n    End Property\nEnd Class