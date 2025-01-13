using Antlr4.Runtime;\nusing Antlr4.Runtime.Tree;\n\n// Assume 'query' is the user-provided query\nstring query = "SELECT * FROM customers WHERE country='USA'";\n\n// Create an ANTLR parser\nvar parser = new TSqlParser(new AntlrInputStream(query));\n\n// Parse the query\nvar tree = parser.tsql_file();\n\n// Rewrite the query to enforce security controls\nvar rewrittenQuery = new QueryRewriter().Visit(tree);\n\n// Execute the rewritten query\nusing (var connection = new SqlConnection(connectionString))\n{\n    connection.Open();\n    var command = new SqlCommand(rewrittenQuery, connection);\n    var reader = command.ExecuteReader();\n    // ...\n}\n\npublic class QueryRewriter : TSqlBaseVisitor<string>\n{\n    public override string VisitSelect_stmt(Select_stmtContext context)\n    {\n        // Enforce column permissions\n        var columns = context.column_alias_list().column_alias();\n        foreach (var column in columns)\n        {\n            if (!IsColumnAllowed(column.GetText()))\n            {\n                throw new SecurityException("Access denied to column");\n            }\n        }\n\n        // Rewrite the query to include row-level security\n        var rewrittenQuery = context.GetText() + " WHERE " + GetRowLevelSecurityClause();\n        return rewrittenQuery;\n    }\n\n    // ...\n}