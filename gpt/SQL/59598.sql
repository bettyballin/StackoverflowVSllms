-- Example SQL for tagging data\n   ALTER TABLE users ADD COLUMN environment VARCHAR(10);\n   \n   -- Insert demo data\n   INSERT INTO users (username, password, environment) VALUES ('demo_user', 'demo_pass', 'demo');\n   \n   -- Insert live data\n   INSERT INTO users (username, password, environment) VALUES ('live_user', 'live_pass', 'live');