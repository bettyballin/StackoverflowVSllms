SELECT \n    banners.id,\n    banners.title,\n    banners.text,\n    GROUP_CONCAT(languages.language_code ORDER BY languages.language_code SEPARATOR ', ') AS languages\nFROM \n    banners\nJOIN \n    content_id_country ON content_id_country.content_id = banners.id\nJOIN \n    languages ON content_id_country.language_id = languages.id\nWHERE \n    content_id_country.controller = 'banners'\nGROUP BY \n    banners.id, banners.title, banners.text;