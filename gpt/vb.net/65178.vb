Public Class Form1\n\n    ' Initialize components and set up initial panel visibility\n    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load\n        ShowPanel(PanelMenu) ' Show the main menu panel by default\n    End Sub\n\n    ' Method to show a specific panel and hide others\n    Private Sub ShowPanel(panelToShow As Panel)\n        ' List all panels\n        Dim panels As List(Of Panel) = New List(Of Panel) From {PanelMenu, PanelSettings, PanelGame}\n\n        ' Hide all panels\n        For Each panel As Panel In panels\n            panel.Visible = False\n        Next\n\n        ' Show the selected panel\n        panelToShow.Visible = True\n        panelToShow.BringToFront()\n    End Sub\n\n    ' Example Button Click event to switch to the settings panel\n    Private Sub BtnSettings_Click(sender As Object, e As EventArgs) Handles BtnSettings.Click\n        ShowPanel(PanelSettings)\n    End Sub\n\n    ' Example Button Click event to switch to the game panel\n    Private Sub BtnStartGame_Click(sender As Object, e As EventArgs) Handles BtnStartGame.Click\n        ShowPanel(PanelGame)\n    End Sub\n\n    ' Example Button Click event to switch back to the menu panel\n    Private Sub BtnBackToMenu_Click(sender As Object, e As EventArgs) Handles BtnBackToMenu.Click\n        ShowPanel(PanelMenu)\n    End Sub\n\nEnd Class