SELECT localTable.Column1, remoteTable.Column2\nFROM LocalDatabase.dbo.LocalTable localTable\nJOIN [LinkedServerName].[RemoteDatabase].[dbo].[RemoteTable] remoteTable\nON localTable.ID = remoteTable.ID;