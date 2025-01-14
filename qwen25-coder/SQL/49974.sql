CREATE TABLE items (\n    item_id INT PRIMARY KEY AUTO_INCREMENT,\n    name VARCHAR(255) NOT NULL,  -- Non-localized attribute example\n    description TEXT             -- Another non-localized attribute example\n);\n\nCREATE TABLE locales (\n    locale_code CHAR(10) PRIMARY KEY,  -- e.g., 'en-US', 'fr-FR'\n    language_name VARCHAR(100)         -- Human-readable name of the language\n);\n\nCREATE TABLE item_localizations (\n    localization_id INT PRIMARY KEY AUTO_INCREMENT,\n    item_id INT NOT NULL,\n    locale_code CHAR(10) NOT NULL,\n    localized_name VARCHAR(255),\n    localized_description TEXT,\n    FOREIGN KEY (item_id) REFERENCES items(item_id),\n    FOREIGN KEY (locale_code) REFERENCES locales(locale_code)\n);