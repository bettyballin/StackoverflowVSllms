SELECT \n  p.ID, \n  p.NAME, \n  COALESCE(GROUP_CONCAT(t.NAME SEPARATOR ', '), '') AS TAGS\nFROM \n  page p\n  LEFT JOIN pagetag pt ON p.ID = pt.PAGEID\n  LEFT JOIN tag t ON pt.TAGID = t.ID\nGROUP BY \n  p.ID, \n  p.NAME\nORDER BY \n  p.ID;