// Storing credentials in session\nSession["DatabaseUsername"] = username;\nSession["DatabasePassword"] = password;\n\n// Retrieving credentials from session\nstring username = Session["DatabaseUsername"] as string;\nstring password = Session["DatabasePassword"] as string;\n\n// Ensure to clear session upon user logout or completion of the task\nSession.Remove("DatabaseUsername");\nSession.Remove("DatabasePassword");