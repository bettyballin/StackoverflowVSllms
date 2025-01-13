using (SqlConnection conn = new SqlConnection("your_connection_string"))\n{\n    conn.Open();\n    \n    using (SqlTransaction transaction = conn.BeginTransaction(IsolationLevel.Serializable))\n    {\n        try\n        {\n            var widgets = FindNewestWidgets();\n\n            foreach (var widget in widgets)\n            {\n                SqlCommand mergeCmd = new SqlCommand(@"\n                    MERGE INTO Widgets AS target\n                    USING (SELECT @WidgetId AS WidgetId, @WidgetData AS WidgetData) AS source\n                    ON target.WidgetId = source.WidgetId\n                    WHEN NOT MATCHED BY TARGET THEN\n                        INSERT (WidgetId, WidgetData) VALUES (source.WidgetId, source.WidgetData);", conn, transaction);\n\n                mergeCmd.Parameters.AddWithValue("@WidgetId", widget.Id);\n                mergeCmd.Parameters.AddWithValue("@WidgetData", widget.Data);\n                mergeCmd.ExecuteNonQuery();\n            }\n\n            transaction.Commit();\n        }\n        catch (Exception ex)\n        {\n            transaction.Rollback();\n            throw;\n        }\n    }\n}