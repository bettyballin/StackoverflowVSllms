CREATE TABLE user_permissions (\n    user_id INT PRIMARY KEY,\n    can_post BOOLEAN DEFAULT FALSE,\n    can_edit BOOLEAN DEFAULT FALSE,\n    can_delete BOOLEAN DEFAULT FALSE\n);