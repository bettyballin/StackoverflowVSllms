CREATE TABLE word (\n    id    integer      PRIMARY KEY,\n    word  varchar(32)  NOT NULL UNIQUE\n);\n\nCREATE TABLE word_link (\n    word1  integer      REFERENCES word(id) NOT NULL,\n    word2  integer      REFERENCES word(id) NOT NULL,\n    PRIMARY KEY (word1, word2),\n    CHECK (word1 < word2)\n);\n\nINSERT INTO word (id, word) VALUES (1, 'revolve');\nINSERT INTO word (id, word) VALUES (2, 'rotate');\n\nINSERT INTO word_link (word1, word2) VALUES (1, 2);