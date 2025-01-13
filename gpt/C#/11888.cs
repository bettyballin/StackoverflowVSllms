public void UpdateDisplayOrder(List<int> orderedIds)\n{\n    var query = new StringBuilder();\n    for (int i = 0; i < orderedIds.Count; i++)\n    {\n        query.AppendFormat("UPDATE YourTable SET DisplayOrder = {0} WHERE Id = {1}; ", i + 1, orderedIds[i]);\n    }\n\n    using (var connection = new SqlConnection("YourConnectionString"))\n    {\n        connection.Open();\n        using (var transaction = connection.BeginTransaction())\n        {\n            using (var command = new SqlCommand(query.ToString(), connection, transaction))\n            {\n                command.ExecuteNonQuery();\n            }\n            transaction.Commit();\n        }\n    }\n}