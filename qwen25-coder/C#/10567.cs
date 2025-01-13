if (!System.Guid.TryParse(Request.QueryString["id"], out Guid userId))\n{\n    // Handle the case where the Guid is not valid or not provided\n    throw new ArgumentException("Invalid GUID in query string.");\n}