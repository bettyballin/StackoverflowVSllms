sSQL = "SELECT * FROM [Service Schedule] WHERE ID=2 AND Volume <= 3000 AND Term='Monthly' AND special = 'Regular' ORDER BY Volume"\n   Debug.Print sSQL\n   Set rsServiceSched = CurrentDb.OpenRecordset(sSQL, dbOpenDynaset, dbSeeChanges)