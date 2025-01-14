-- Step 1: Insert into text table\nINSERT INTO `text` (old_text, old_flags) VALUES ('Content of the new article', 'utf-8');\n\n-- Assume last_insert_id() fetches the last inserted ID in `text`\nSET @lastTextID = LAST_INSERT_ID();\n\n-- Step 2: Insert into page table\nINSERT INTO `page` (namespace, title) VALUES (0, 'NewArticleTitle');\n\n-- Assume last_insert_id() fetches the last inserted ID in `page`\nSET @lastPageID = LAST_INSERT_ID();\n\n-- Step 3: Insert into revision table\nINSERT INTO `revision` (\n    rev_page, \n    rev_text_id, \n    rev_comment, \n    rev_user_text, \n    rev_timestamp\n) VALUES (\n    @lastPageID, \n    @lastTextID, \n    'Initial page creation', \n    'AnAdminOrBotName', \n    NOW()\n);\n\n-- Update page table with the latest revision ID\nUPDATE `page` SET page_latest = LAST_INSERT_ID(), page_len = (SELECT CHAR_LENGTH(old_text) FROM text WHERE old_id = @lastTextID) WHERE page_id = @lastPageID;