SELECT \n    s.name AS SubscriptionName,\n    a.subs_type AS SubscriptionType,\n    CASE a.subs_type \n        WHEN 1 THEN 'Push'\n        WHEN 2 THEN 'Pull'\n        WHEN 3 THEN 'Anonymous'\n        ELSE 'Unknown'\n    END AS SubscriptionDescription,\n    ah.runstatus AS LastRunStatus,\n    CASE ah.runstatus\n        WHEN 0 THEN 'Idle'\n        WHEN 1 THEN 'Starting'\n        WHEN 2 THEN 'Running'\n        WHEN 3 THEN 'Succeeded'\n        WHEN 4 THEN 'In Progress'\n        WHEN 5 THEN 'Idle'\n        WHEN 6 THEN 'Retrying'\n        WHEN 7 THEN 'Failed'\n        ELSE 'Unknown'\n    END AS LastRunStatusDescription,\n    ah.start_time AS LastStartTime,\n    ah.end_time AS LastEndTime\nFROM \n    distribution.dbo.MSsubscriptions AS s\nJOIN \n    distribution.dbo.MSsubscription_agents AS a ON s.subscription_id = a.id\nJOIN \n    distribution.dbo.MSlogreader_history AS ah ON a.id = ah.agent_id OR a.id = ah.subscription_id\nWHERE \n    ah.start_time >= (\n        SELECT MAX(start_time)\n        FROM distribution.dbo.MSlogreader_history h2\n        WHERE h2.agent_id = a.id OR h2.subscription_id = a.id\n    )\nORDER BY \n    LastEndTime DESC;