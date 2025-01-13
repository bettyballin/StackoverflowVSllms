string[] allowedColumns = { "title", "description", "otherColumn" };\n\nstring fieldName = Request.QueryString["fieldname"];\nif (allowedColumns.Contains(fieldName))\n{\n    string query = $"UPDATE MyTable SET {fieldName} = @fieldValue WHERE id = @id";\n    SqlCommand cmd = new SqlCommand(query);\n    cmd.Parameters.AddWithValue("@fieldValue", fieldValue);\n    cmd.Parameters.AddWithValue("@id", id);\n    // execute the query\n}\nelse\n{\n    // handle invalid column name\n}