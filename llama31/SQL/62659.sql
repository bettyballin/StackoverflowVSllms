CREATE TABLE sessions (\n    session_id varchar(255) NOT NULL,\n    ip_address varchar(45) NOT NULL,\n    user_agent varchar(255) NOT NULL,\n    last_activity int(10) unsigned NOT NULL,\n    user_data text NOT NULL,\n    PRIMARY KEY (session_id)\n);