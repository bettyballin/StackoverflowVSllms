try\n   {\n       // Load the dataset...\n   }\n   catch (ConstraintException ex)\n   {\n       Console.WriteLine($"ConstraintException occurred: {ex.Message}");\n       // Log the exception or provide a user-friendly error message\n   }