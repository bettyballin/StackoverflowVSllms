string session;\nif (Session != null && Session.ContainsKey("variable") && !String.IsNullOrEmpty(Session["variable"] as string))\n{\n    session = Session["variable"].ToString();\n}\nelse\n{\n    session = "set this";\n    Session["variable"] = session;\n}