UPDATE your_table_name\nSET content_url = REPLACE(content_url, 'file:///c:/users/nazgulled/music/band%20albums/', 'file:///c:/users/nazgulled/music/bands/studio%20albums/')\nWHERE content_url LIKE 'file:///c:/users/nazgulled/music/band%20albums/%';