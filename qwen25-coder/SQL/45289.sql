-- Example SQL table for homepage configurations\n   CREATE TABLE homepage_config (\n       id INT PRIMARY KEY AUTO_INCREMENT,\n       product_id VARCHAR(255),\n       position ENUM('main', 'secondary')\n   );