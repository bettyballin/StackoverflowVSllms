WITH RankedSlots AS (\n  SELECT \n    ps.slotnumber, \n    ps.fileid, \n    s.rank,\n    ROW_NUMBER() OVER (PARTITION BY ps.slotnumber ORDER BY s.rank DESC) AS rownum\n  FROM \n    PlaylistSlots ps\n  INNER JOIN \n    Schedules s ON ps.playlistid = s.playlistid\n)\nSELECT \n  slotnumber, \n  fileid, \n  rank\nFROM \n  RankedSlots\nWHERE \n  rownum = 1\nORDER BY \n  slotnumber;