Public Class MyDialogBox\n\n    ' Assuming RdoButton1, RdoButton2, RdoButton3 are your RadioButtons\n    ' And UserSelectionSetting is an Enum representing user selection\n\n    ' Load settings when form is loaded\n    Private Sub MyDialogBox_Load(sender As Object, e As EventArgs) Handles MyBase.Load\n        Select Case My.Settings.SelectedRadioButton\n            Case 1\n                RdoButton1.Checked = True\n            Case 2\n                RdoButton2.Checked = True\n            Case 3\n                RdoButton3.Checked = True\n            Case Else ' Default to first radio button if nothing is selected\n                RdoButton1.Checked = True\n        End Select\n    End Sub\n\n    ' Save settings when form is closed\n    Private Sub MyDialogBox_FormClosed(sender As Object, e As FormClosedEventArgs) Handles MyBase.FormClosed\n        If RdoButton1.Checked Then\n            My.Settings.SelectedRadioButton = 1\n        ElseIf RdoButton2.Checked Then\n            My.Settings.SelectedRadioButton = 2\n        ElseIf RdoButton3.Checked Then\n            My.Settings.SelectedRadioButton = 3\n        End If\n\n        ' Save the settings to storage\n        My.Settings.Save()\n    End Sub\n\nEnd Class