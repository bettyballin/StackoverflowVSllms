CREATE TABLE examples (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    description TEXT DEFAULT NULL,  -- Using NULL for no data\n    note TEXT NOT NULL DEFAULT ''     -- Using empty string for explicitly set no data\n);