using System;\nusing System.Web.UI;\n\npublic partial class OracleReportViewer : Page\n{\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        // Define the Oracle Reports Server URL\n        string reportServerUrl = "http://your-report-server:port/reports/rwservlet";\n\n        // Define the parameters for the report\n        string reportName = "your_report.rdf";\n        string userId = "your_db_user/your_db_password@your_db_service";\n        string reportFormat = "pdf"; // Can be pdf, html, xml, etc.\n        string param1 = "value1";\n        string param2 = "value2";\n\n        // Construct the URL for the report\n        string reportUrl = $"{reportServerUrl}?report={reportName}&userid={userId}&desformat={reportFormat}&paramform=no&P_PARAM1={param1}&P_PARAM2={param2}";\n\n        // Redirect to the report URL to display the report\n        Response.Redirect(reportUrl);\n    }\n}