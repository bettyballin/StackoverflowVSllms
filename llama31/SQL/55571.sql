SELECT \n    Author, \n    COUNT(ReportID) AS ReportCount\nFROM \n    Reports\nWHERE \n    DateCreated >= [Start Date] AND DateCreated <= [End Date]\nGROUP BY \n    Author