INSERT INTO i_mails (\n    id,\n    from_mails,\n    to_mails,\n    cc_mails,\n    subject,\n    body,\n    anchor_level_id,\n    attachment,\n    forward_status,\n    reply_status,\n    delete_status,\n    read_status,\n    received_date,\n    response_date,\n    batch,\n    forward_score,\n    delete_score,\n    priority,\n    is_auto_reply,\n    parent_mail_id,\n    case_id,\n    time_bound\n)\nVALUES (\n    1,\n    a@a.com,\n    a@a.com,\n    a@a.com,\n    Hi,\n    --long html field--,\n    7,\n    -1,  -- attachment (Yes)\n    0,   -- forward_status (No)\n    0,   -- reply_status (No)\n    0,   -- delete_status (No)\n    0,   -- read_status (No)\n    DateValue('2000-12-12 00:00:00'),\n    DateValue('2000-12-12 00:00:00'),\n    0,\n    0,\n    0,\n    1,\n    0,   -- is_auto_reply (No)\n    0,\n    2,\n    0\n)