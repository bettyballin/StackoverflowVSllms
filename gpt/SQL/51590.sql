SELECT \n    e.event_id, \n    s.subscription_id\nFROM \n    events e\nINNER JOIN \n    subscriptions s\nON \n    e.event_date BETWEEN s.start_date AND s.end_date;