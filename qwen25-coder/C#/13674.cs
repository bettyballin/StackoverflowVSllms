protected void SavePreferences(Dictionary<string, bool> preferences)\n{\n    Profile.SetPropertyValue("ColumnPreferences", preferences);\n}