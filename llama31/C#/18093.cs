// server-side C#\nvar schema = JSchema.Parse(schemaJson);\nvar jsonData = JObject.Parse(dataJson);\nif (!jsonData.IsValid(schema)) {\n    // handle invalid data\n}