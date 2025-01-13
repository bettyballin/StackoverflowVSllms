SELECT a.stage_name, COUNT(b.id)\nFROM authors a\n  LEFT OUTER JOIN books b ON (a.id = b.author_id)\nGROUP BY a.id;