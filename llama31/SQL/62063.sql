CREATE TABLE faqs (\n  id INT PRIMARY KEY,\n  question TEXT,\n  answer TEXT,\n  FULLTEXT (question, answer)\n);\n\nSELECT * FROM faqs WHERE MATCH (question, answer) AGAINST (:search_term IN BOOLEAN MODE);