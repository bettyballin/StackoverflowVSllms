SELECT 'T' OBJECTTYPE, TABLE_NAME OBJECTNAME \nFROM ALL_TAB_COLUMNS \nWHERE OWNER = 'SONAR5'\nUNION ALL\nSELECT 'V' OBJECTTYPE, VIEW_NAME OBJECTNAME \nFROM ALL_VIEWS \nWHERE OWNER = 'SONAR5'\nORDER BY OBJECTNAME;