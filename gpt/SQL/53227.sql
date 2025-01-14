CREATE TABLE sub_posts_meta (\n        id INT AUTO_INCREMENT PRIMARY KEY,\n        root_post_id INT NOT NULL,\n        user_id INT NOT NULL,\n        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n        -- other metadata fields\n        FOREIGN KEY (root_post_id) REFERENCES root_posts_meta(id),\n        FOREIGN KEY (user_id) REFERENCES users(id)\n    );