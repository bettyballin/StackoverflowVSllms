CREATE TABLE `comments` (\n    `id` INT AUTO_INCREMENT PRIMARY KEY,\n    `parent_id` INT DEFAULT 0,\n    `comment_text` TEXT NOT NULL,\n    `name` VARCHAR(50) NOT NULL,\n    `email` VARCHAR(100),\n    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n);