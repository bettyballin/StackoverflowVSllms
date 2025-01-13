DECLARE\n  p_cursor refcursor;\n\nBEGIN\n\n  OPEN p_cursor FOR\n\n  SELECT \n    table1.name,\n    table1.timetag AS table1_timetag,\n    table1.status,\n    table2.timetag AS table2_timetag,\n    table2.description\n\n  FROM myFirstTable table1 \n  LEFT OUTER JOIN mySecondTable table2 ON (<data's ids>),\n  (<query details>)\n  WHERE\n  <more query details>\n\n  RETURN p_cursor;\n\nEND;