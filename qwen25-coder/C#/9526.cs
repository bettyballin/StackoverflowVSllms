if (resultSet.Rows[0].IsNull("fk_id"))\n{\n    // This will also be reached if the "fk_id" field is null in the database.\n}