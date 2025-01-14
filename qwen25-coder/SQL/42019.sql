-- Creating a new article\nINSERT INTO articles (title, content) VALUES ('My First Article', 'This is the initial content.');\n\n-- Editing an existing article with id 1\n-- Step 1: Save current version as in article_versions\nINSERT INTO article_versions (article_id, title, content)\nSELECT article_id, title, content FROM articles WHERE article_id = 1;\n\n-- Step 2: Update articles table with new content\nUPDATE articles SET title = 'My Updated Article', content = 'This is the updated content.' WHERE article_id = 1;