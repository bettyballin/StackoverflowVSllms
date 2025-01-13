using System;\nusing System.Data;\nusing System.Web.UI;\nusing Oracle.ManagedDataAccess.Client;\n\npublic partial class YourPage : Page\n{\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        if (!IsPostBack)\n        {\n            BindGridView();\n        }\n    }\n\n    private void BindGridView()\n    {\n        string connectionString = "your_oracle_connection_string";\n        using (OracleConnection conn = new OracleConnection(connectionString))\n        {\n            using (OracleCommand cmd = new OracleCommand("GETSOMEDATA", conn))\n            {\n                cmd.CommandType = CommandType.StoredProcedure;\n                \n                OracleParameter outputParameter = new OracleParameter();\n                outputParameter.ParameterName = "P_Data";\n                outputParameter.OracleDbType = OracleDbType.RefCursor;\n                outputParameter.Direction = ParameterDirection.Output;\n                cmd.Parameters.Add(outputParameter);\n                \n                conn.Open();\n                using (OracleDataAdapter da = new OracleDataAdapter(cmd))\n                {\n                    DataTable dt = new DataTable();\n                    da.Fill(dt);\n                    grdData.DataSource = dt;\n                    grdData.DataBind();\n                }\n            }\n        }\n    }\n}