SELECT COUNT(*) FROM FailedLogins\n    WHERE ip_address = ? AND attempt_time > (NOW() - INTERVAL 5 MINUTE);