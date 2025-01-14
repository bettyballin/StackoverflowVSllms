SELECT \n    pm_info.is_read,\n    sender.usrFirst AS sender_name,\n    pm_data.date_sent,  \n    pm_data.title, \n    pm_data.thread_id, \n    pm_data.id AS dataid, \n    thread_max_date_sent\nFROM \n    pm_info\nINNER JOIN \n    (SELECT \n         pm_data.thread_id, \n         MAX(pm_data.date_sent) AS thread_max_date_sent \n     FROM \n         pm_data \n     GROUP BY \n         pm_data.thread_id\n    ) deriv1 ON pm_data.thread_id = deriv1.thread_id AND pm_data.date_sent = deriv1.thread_max_date_sent\nINNER JOIN \n    pm_data ON pm_info.message_id = pm_data.id\nINNER JOIN \n    tblUsers AS sender ON pm_data.sender_id = sender.usrID\nWHERE \n    pm_info.receiver_id = '$usrID'\nORDER BY \n    deriv1.thread_max_date_sent DESC;