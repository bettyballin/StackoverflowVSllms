# Run periodically via cron\nmysql -u user -ppassword << EOF\nDELETE FROM foo WHERE to_be_deleted = TRUE AND created_at < DATE_SUB(NOW(), INTERVAL 30 DAY);\nEOF