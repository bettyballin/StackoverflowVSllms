-- Ensure that username column is indexed if used in WHERE clause frequently\n   CREATE INDEX idx_username ON users(username);