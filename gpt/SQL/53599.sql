ALTER TABLE content_items DROP INDEX your_fulltext_index;\nALTER TABLE content_items ADD FULLTEXT your_fulltext_index (content, name);