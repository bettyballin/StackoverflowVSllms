SELECT\n    lat.LAT AS Lat,\n    lon.LON AS Lon\nFROM\n    Address_Location WITH(NOLOCK)\nCROSS APPLY\n    dbo.usf_GIS_GET_LAT_TV(City, [State]) AS lat\nCROSS APPLY\n    dbo.usf_GIS_GET_LON_TV(City, [State]) AS lon\nWHERE\n    ID IN (SELECT TOP 100 ID FROM Address_Location WITH(NOLOCK) ORDER BY ID DESC)