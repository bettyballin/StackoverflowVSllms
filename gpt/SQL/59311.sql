SELECT failed_attempts, last_attempt_time FROM FailedLoginSummary\n    WHERE ip_address = ? AND last_attempt_time > (NOW() - INTERVAL 5 MINUTE);