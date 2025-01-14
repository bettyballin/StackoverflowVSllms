Imports Microsoft.Reporting.WebForms\n\nPartial Class _Default\n    Inherits System.Web.UI.Page\n\n    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load\n        If Not IsPostBack Then\n            ' Initialize the ReportViewer control\n            ReportViewer1.ProcessingMode = ProcessingMode.Remote\n\n            ' Set the report server and report path\n            Dim reportServerUrl As String = "http://YourReportServer/ReportServer"\n            ReportViewer1.ServerReport.ReportServerUrl = New Uri(reportServerUrl)\n            ReportViewer1.ServerReport.ReportPath = "/YourReportFolder/YourReportName"\n\n            ' Define parameters for the report\n            Dim myParam(0) As ReportParameter\n\n            ' Set parameter name and value\n            myParam(0) = New ReportParameter("YourParameterName", "YourParameterValue")\n\n            ' Pass the parameters to the report\n            ReportViewer1.ServerReport.SetParameters(myParam)\n\n            ' Refresh the report to apply the new parameters\n            ReportViewer1.ServerReport.Refresh()\n        End If\n    End Sub\nEnd Class