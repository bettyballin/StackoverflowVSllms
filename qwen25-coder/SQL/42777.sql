SELECT \n  REPEAT('~~', level - 1) || name AS indented_page_name\nFROM \n  pages\nORDER BY \n  id, parent_id;