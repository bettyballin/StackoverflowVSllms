// C# Code\ntry\n{\n    // Code that might throw an exception\n}\ncatch (Exception ex) when (ExceptionFilterHelper.Filter(ex, "MyPolicy"))\n{\n    // This block will only execute if the filter returns true\n    // Recover from the exception\n}