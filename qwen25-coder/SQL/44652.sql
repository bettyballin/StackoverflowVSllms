SELECT *\nFROM YourTable\nWHERE DATEPART(year, YourDateTimeField) = DATEPART(year, GETDATE());