CREATE TABLE translations (\n    translation_id INTEGER PRIMARY KEY AUTO_INCREMENT,\n    word_id INTEGER NOT NULL,\n    translation VARCHAR(255) NOT NULL,\n    contributor INTEGER NOT NULL,\n    lang INTEGER NOT NULL,\n    FOREIGN KEY (word_id) REFERENCES words(word_id),\n    FOREIGN KEY (contributor) REFERENCES contributors(contributor_id),\n    FOREIGN KEY (lang) REFERENCES languages(lang_id)\n);