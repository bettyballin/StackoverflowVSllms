CREATE TABLE words (\n    word_id INTEGER PRIMARY KEY AUTO_INCREMENT,\n    word VARCHAR(255) NOT NULL,\n    translation_for INTEGER,\n    contributor INTEGER NOT NULL,\n    lang INTEGER,\n    FOREIGN KEY (translation_for) REFERENCES words(word_id),\n    FOREIGN KEY (contributor) REFERENCES contributors(contributor_id),\n    FOREIGN KEY (lang) REFERENCES languages(lang_id)\n);