Private Sub simulateButtonPress(ByRef pictureBox As Infragistics.Win.UltraWinEditors.UltraPictureBox)\n    pictureBox.BorderStyle = Infragistics.Win.UIElementBorderStyle.Inset\n    Application.DoEvents()\n    System.Threading.Thread.Sleep(400)\n    pictureBox.BorderStyle = Infragistics.Win.UIElementBorderStyle.Raised\n    Application.DoEvents()\nEnd Sub