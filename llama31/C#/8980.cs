using System;\nusing System.Xml;\nusing System.Data.SqlClient;\n\npublic class RuleEngine\n{\n  public void ExecuteRules()\n  {\n    // Load rules from XML file\n    XmlDocument rulesDoc = new XmlDocument();\n    rulesDoc.Load("rules.xml");\n\n    // Connect to database\n    SqlConnection conn = new SqlConnection("your connection string");\n    conn.Open();\n\n    // Iterate through rules and execute them against data\n    foreach (XmlNode ruleNode in rulesDoc.SelectNodes("/rules/rule"))\n    {\n      string ruleName = ruleNode.Attributes["name"].Value;\n      string condition = ruleNode.SelectSingleNode("condition").InnerText;\n\n      // Execute rule against data\n      SqlCommand cmd = new SqlCommand("SELECT * FROM customers WHERE " + condition, conn);\n      SqlDataReader reader = cmd.ExecuteReader();\n\n      // Process results\n      while (reader.Read())\n      {\n        Console.WriteLine($"Customer {reader["name"]} does not meet rule {ruleName}");\n      }\n    }\n  }\n}