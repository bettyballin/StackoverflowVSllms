using System.Transactions;\n\n// Create a new transaction scope\nusing (var transactionScope = new TransactionScope())\n{\n    // All database connections within this scope will be enlisted in the transaction\n    // ... perform UI testing using Watin ...\n\n    // Rollback the transaction\n    transactionScope.Dispose();\n}