using System;\nusing System.Data.SqlClient;\n\nnamespace YourNamespace\n{\n    public partial class MasterPage : System.Web.UI.MasterPage\n    {\n        protected SqlConnection sqlConnection;\n\n        protected void Page_Init(object sender, EventArgs e)\n        {\n            string connectionString = "your-connection-string";\n            sqlConnection = new SqlConnection(connectionString);\n            sqlConnection.Open();\n        }\n\n        protected void Page_Unload(object sender, EventArgs e)\n        {\n            if (sqlConnection != null && sqlConnection.State == System.Data.ConnectionState.Open)\n            {\n                sqlConnection.Close();\n            }\n        }\n    }\n}