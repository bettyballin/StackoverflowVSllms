// Generate a new GUID and store it in the session\nif (Session["UniqueSessionID"] == null)\n{\n    Session["UniqueSessionID"] = Guid.NewGuid().ToString();\n}\n\n// Retrieve the GUID from the session\nstring uniqueSessionID = Session["UniqueSessionID"].ToString();