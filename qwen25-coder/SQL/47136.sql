SELECT \n    1 as tag,\n    NULL as parent,\n    NULL as [root!1!!ELEMENT],\n    NULL as [clientID!2!clientID]\nFROM \n    Location.LocationMDAccount\nWHERE \n    locationid = 'long-guid-here'\n\nUNION ALL\n\nSELECT \n    2 as tag,\n    1 as parent,\n    NULL as [root!1!!ELEMENT],\n    AccountNumber as [clientID!2!clientID]\nFROM \n    Location.LocationMDAccount\nWHERE \n    locationid = 'long-guid-here'\nFOR XML EXPLICIT;