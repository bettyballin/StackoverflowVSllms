Private Sub btnOtherReport_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnOtherReport.Click\n    rvReport.ProcessingMode = ProcessingMode.Remote\n    rvReport.ShowParameterPrompts = False\n    rvReport.ServerReport.ReportServerUrl = New Uri("REPORT_SERVER_URL")\n    rvReport.ServerReport.ReportPath = "REPORT_PATH"\n    rvReport.BackColor = Color.White\n\n    ' Set the progress bar to marquee style before starting the background worker.\n    pbReports.Style = ProgressBarStyle.Marquee\n    BackgroundWorker1.RunWorkerAsync()\nEnd Sub\n\nPrivate Sub BackgroundWorker1_DoWork(ByVal sender As Object, ByVal e As System.ComponentModel.DoWorkEventArgs) Handles BackgroundWorker1.DoWork\n    ' Perform the report refresh on a separate thread.\n    RefreshReport()\nEnd Sub\n\nPrivate Sub BackgroundWorker1_RunWorkerCompleted(ByVal sender As Object, ByVal e As System.ComponentModel.RunWorkerCompletedEventArgs) Handles BackgroundWorker1.RunWorkerCompleted\n    ' Reset the progress bar style after the operation is complete.\n    pbReports.Style = ProgressBarStyle.Blocks\n    pbReports.Value = 100\nEnd Sub\n\nPublic Sub RefreshReport()\n    rvReport.BeginInvoke(New MethodInvoker(AddressOf rvReport.RefreshReport))\nEnd Sub