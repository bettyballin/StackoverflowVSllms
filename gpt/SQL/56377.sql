UPDATE TableToUpdate\nSET EndTimeKey = d.DATE_NO\nFROM Dates d\nWHERE TableToUpdate.EndTime = d.DATE;