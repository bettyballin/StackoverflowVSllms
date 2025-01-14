SELECT Author, COUNT(*) AS ReportCount\nFROM Reports\nWHERE DateCreated BETWEEN [Forms]![YourFormName]![txtStartDate] AND [Forms]![YourFormName]![txtEndDate]\nGROUP BY Author;