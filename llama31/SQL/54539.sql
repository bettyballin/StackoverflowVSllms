SELECT COUNT(*) AS count,\n       TRUNC(created) AS created\nFROM ABC\nGROUP BY TRUNC(created)\nORDER BY created DESC;