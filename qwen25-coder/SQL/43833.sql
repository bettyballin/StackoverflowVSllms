CREATE TABLE scheduled_tasks (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    script_path VARCHAR(255) NOT NULL,\n    run_time TIME NOT NULL,\n    last_ran TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP\n);