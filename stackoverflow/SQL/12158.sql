SELECT *\nFROM   users \n       LEFT JOIN suspensions \n       ON suspensions.user_id=users.id AND suspensions.suspended_date > now()