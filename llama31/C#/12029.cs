try\n{\n    // Call your sproc here\n}\ncatch (DbUpdateException ex)\n{\n    if (ex.InnerException is SqlException sqlEx && (sqlEx.Number == 2601 || sqlEx.Number == 2627))\n    {\n        // Unique key exception, throw your custom error\n        throw new CustomUniqueKeyException();\n    }\n    else\n    {\n        // Re-throw the original exception\n        throw;\n    }\n}