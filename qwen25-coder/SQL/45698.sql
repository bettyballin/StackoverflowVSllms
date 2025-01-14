SELECT 'listings' as source, id, title, date_added FROM listings\nUNION ALL\nSELECT 'photos' as source, id, filename, upload_date AS date_added FROM photos\nUNION ALL\nSELECT 'comments' as source, id, content, post_time AS date_added FROM comments\nORDER BY date_added DESC;