CREATE TABLE rss_items (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    title TEXT NOT NULL,\n    link TEXT NOT NULL,\n    description TEXT,\n    pub_date DATETIME NOT NULL\n);