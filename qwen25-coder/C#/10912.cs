using System;\nusing System.Configuration;\nusing System.Data.SqlClient;\n\npublic class Global : HttpApplication\n{\n    protected void Session_Start(object sender, EventArgs e)\n    {\n        // Store the start time of the session in the Session object.\n        Session["SessionStartTime"] = DateTime.Now;\n\n        // Optionally log this directly to your database or set up a cache for later logging.\n        LogSessionStart(Session.SessionID);\n    }\n\n    private void LogSessionStart(string sessionId)\n    {\n        string connectionString = ConfigurationManager.ConnectionStrings["YourConnectionStringName"].ConnectionString;\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            using (SqlCommand command = new SqlCommand("INSERT INTO Sessions (SessionId, StartTime) VALUES (@SessionId, @StartTime)", connection))\n            {\n                command.Parameters.AddWithValue("@SessionId", sessionId);\n                command.Parameters.AddWithValue("@StartTime", DateTime.Now);\n\n                connection.Open();\n                command.ExecuteNonQuery();\n            }\n        }\n    }\n\n    protected void Session_End(object sender, EventArgs e)\n    {\n        // Log the session end time to your database.\n        string sessionId = Session.SessionID;\n        LogSessionEnd(sessionId, (DateTime)Session["SessionStartTime"], DateTime.Now);\n    }\n\n    private void LogSessionEnd(string sessionId, DateTime startTime, DateTime endTime)\n    {\n        string connectionString = ConfigurationManager.ConnectionStrings["YourConnectionStringName"].ConnectionString;\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            using (SqlCommand command = new SqlCommand("UPDATE Sessions SET EndTime = @EndTime WHERE SessionId = @SessionId", connection))\n            {\n                command.Parameters.AddWithValue("@SessionId", sessionId);\n                command.Parameters.AddWithValue("@EndTime", DateTime.Now);\n\n                connection.Open();\n                command.ExecuteNonQuery();\n            }\n        }\n    }\n}