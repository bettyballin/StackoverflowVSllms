-- Inserting image into a database table using binary format\nINSERT INTO images_table (id, name, img_data)\nVALUES (1, 'example.jpg', LOAD_FILE('/path/to/image/example.jpg'));