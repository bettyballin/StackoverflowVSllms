CREATE TABLE articles (\n        id INT AUTO_INCREMENT PRIMARY KEY,\n        newspaper VARCHAR(255),\n        issue VARCHAR(255),\n        date DATE,\n        page_number INT,\n        ocr_text TEXT,\n        FULLTEXT(ocr_text)\n    );