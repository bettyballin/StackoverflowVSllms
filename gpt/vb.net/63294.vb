Private Sub btnGenerateReport_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnGenerateReport.Click\n    pbReports.Style = ProgressBarStyle.Marquee\n\n    ' Start the long-running task\n    Task.Run(Sub() GenerateReport(ReportType.Roads))\nEnd Sub\n\nPublic Sub GenerateReport(ByVal rt As ReportType)\n    ' Perform the long-running report generation on a background thread\n    rvReport.Invoke(Sub()\n                        rvReport.ProcessingMode = ProcessingMode.Remote\n                        rvReport.ShowParameterPrompts = False\n                        rvReport.ServerReport.ReportServerUrl = New Uri("My_Report_Server_URL")\n                        rvReport.ServerReport.ReportPath = "My_Report_Path"\n                        rvReport.BackColor = Color.White\n\n                        rvReport.RefreshReport()\n                    End Sub)\n\n    ' Stop the progress bar on the UI thread\n    pbReports.Invoke(Sub() StopProgressBar())\nEnd Sub\n\nPrivate Sub StopProgressBar()\n    pbReports.Style = ProgressBarStyle.Blocks\nEnd Sub