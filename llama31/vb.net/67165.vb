Imports Microsoft.Reporting.WebForms\n\nDim report As New ReportViewer\nreport.ServerReport.ReportServerUrl = New Uri("http://yourssrsserver/ReportServer")\nreport.ServerReport.ReportPath = "/YourReportName"\n\nDim reportParameters As New ReportParameter() {New ReportParameter("Parameter1", "Value1"),\n                                             New ReportParameter("Parameter2", "Value2")}\n\nreport.ServerReport.SetParameters(reportParameters)\nreport.ServerReport.Refresh()