CREATE TABLE formatted_text (\n       id INT AUTO_INCREMENT PRIMARY KEY,\n       content TEXT NOT NULL\n   );\n\n   INSERT INTO formatted_text (content) VALUES ('# Heading 1\n\nThis is a paragraph with some **bold** text and *italic* text.\n\n- List item 1\n- List item 2\n- List item 3\n');