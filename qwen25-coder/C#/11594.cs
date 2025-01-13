public async Task<int> ProcessDataAsync(SqlConnection connection, int batchSize)\n{\n    int totalRowsProcessed = 0;\n    int estimatedTotalRows; // This should be calculated beforehand if possible\n\n    using (var command = new SqlCommand("SELECT COUNT(*) FROM YourTable", connection))\n    {\n        estimatedTotalRows = (int)await command.ExecuteScalarAsync();\n    }\n\n    for (int offset = 0; offset < estimatedTotalRows; offset += batchSize)\n    {\n        using (var command = new SqlCommand(\n            "UPDATE TOP (@batchSize) YourTable SET Processed = 1 WHERE Processed = 0 OFFSET @offset ROWS FETCH NEXT @batchSize ROWS ONLY;", \n            connection))\n        {\n            command.Parameters.AddWithValue("@batchSize", batchSize);\n            command.Parameters.AddWithValue("@offset", offset);\n\n            int rowsAffected = await command.ExecuteNonQueryAsync();\n            totalRowsProcessed += rowsAffected;\n\n            // Update UI with progress\n            double progressPercentage = (double)totalRowsProcessed / estimatedTotalRows * 100;\n            Application.Current.Dispatcher.Invoke(() =>\n            {\n                progressBar.Value = progressPercentage; // Assuming you have a ProgressBar control named 'progressBar'\n            });\n        }\n    }\n\n    return totalRowsProcessed;\n}