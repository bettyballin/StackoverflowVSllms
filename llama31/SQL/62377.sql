DELETE FROM accounts WHERE DATE_ADD(subscription_date, INTERVAL 1 WEEK) < NOW();