Public Class Form1\n\n    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load\n        ' Bind the Checked property to the settings\n        RadioButton1.DataBindings.Add(New Binding("Checked", My.Settings, "RadioButton1Checked", True, DataSourceUpdateMode.OnPropertyChanged))\n        RadioButton2.DataBindings.Add(New Binding("Checked", My.Settings, "RadioButton2Checked", True, DataSourceUpdateMode.OnPropertyChanged))\n        RadioButton3.DataBindings.Add(New Binding("Checked", My.Settings, "RadioButton3Checked", True, DataSourceUpdateMode.OnPropertyChanged))\n\n        ' Ensure the initial state is loaded correctly\n        RadioButton1.Checked = My.Settings.RadioButton1Checked\n        RadioButton2.Checked = My.Settings.RadioButton2Checked\n        RadioButton3.Checked = My.Settings.RadioButton3Checked\n    End Sub\n\n    Private Sub Form1_FormClosing(sender As Object, e As FormClosingEventArgs) Handles MyBase.FormClosing\n        ' Save the settings on form close\n        My.Settings.Save()\n    End Sub\n\nEnd Class