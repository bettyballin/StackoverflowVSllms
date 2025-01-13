using System;\nusing System.Data;\nusing System.Web.UI;\nusing CrystalDecisions.CrystalReports.Engine;\n\npublic partial class YourPage : Page\n{\n    ReportDocument rpt = new ReportDocument();\n    string reportpath = null;\n\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        if (!Page.IsPostBack)\n        {\n            if (Request.QueryString.Get("id") == "5")\n            {\n                string publication = Request.QueryString.Get("pub");\n                DateTime date = DateTime.Parse(Request.QueryString.Get("date"));\n                int pages = int.Parse(Request.QueryString.Get("pages"));\n                int sort = int.Parse(Request.QueryString.Get("sort"));\n\n                if (sort == 0)\n                {\n                    reportpath = Server.MapPath("IssuesReport.rpt");\n                    rpt.Load(reportpath);\n                    DataTable resultSet1 = RetrievalProcedures.IssuesReport(date, publication, pages);\n                    Session["Record"] = resultSet1;\n                }\n\n                DataTable report = (DataTable)Session["Record"];\n                rpt.SetDataSource(report);\n                CrystalReportViewer1.ReportSource = rpt;\n            }\n        }\n        else\n        {\n            if (Session["Record"] != null)\n            {\n                DataTable report = (DataTable)Session["Record"];\n                reportpath = Server.MapPath("IssuesReport.rpt");\n                rpt.Load(reportpath);\n                rpt.SetDataSource(report);\n                CrystalReportViewer1.ReportSource = rpt;\n            }\n            else\n            {\n                // Handle the case where session is null, possibly redirect or show an error message.\n                Response.Write("Session has expired. Please reload the report.");\n            }\n        }\n    }\n}