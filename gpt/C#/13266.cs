using Microsoft.Reporting.WebForms;\n\npublic partial class ReportPage : System.Web.UI.Page\n{\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        if (!IsPostBack)\n        {\n            BindReport();\n        }\n    }\n\n    private void BindReport()\n    {\n        DataAccessLayer dal = new DataAccessLayer();\n        DataTable reportData = dal.GetReportData();\n\n        ReportDataSource rds = new ReportDataSource("DataSetName", reportData);\n        ReportViewer1.LocalReport.DataSources.Clear();\n        ReportViewer1.LocalReport.DataSources.Add(rds);\n        ReportViewer1.LocalReport.Refresh();\n    }\n}