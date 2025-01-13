public void DoBackup(string sLogName)\n{\n    string sBackup = sLogName;  // could be for example "Application"\n    EventLog log = new EventLog();\n    log.Source = sBackup;\n\n    var query = from EventLogEntry entry in log.Entries\n                orderby entry.TimeGenerated descending\n                select entry;\n\n    string sBackupName = sBackup+"Log";\n    var xml = new XDocument(\n        new XElement(sBackupName,\n            from EventLogEntry entry in log.Entries\n            orderby entry.TimeGenerated descending\n            select new XElement("Log",\n              new XElement("Message", entry.Message),\n              new XElement("TimeGenerated", entry.TimeGenerated),\n              new XElement("Source", entry.Source),\n              new XElement("EntryType", entry.EntryType.ToString())\n            )\n          )\n        );\n\n    DateTime oggi = DateTime.Now;\n    string sToday = DateTime.Now.ToString("yyyyMMdd_hhmmss");\n    string path = String.Format("{0}_{1}.xml", sBackupName, sToday);\n    xml.Save(Path.Combine(Environment.CurrentDirectory, path));\n}