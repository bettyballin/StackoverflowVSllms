DELETE FROM FailedLoginSummary WHERE last_attempt_time < (NOW() - INTERVAL 1 DAY);