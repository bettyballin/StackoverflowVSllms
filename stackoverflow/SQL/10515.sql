SELECT ta.amount, ta.recipient_id, ta.sender_id, ta.timestamp_insert, sender.name as Sender, recipient.name as Recipient\n        FROM  `transactions` AS ta\n        JOIN users AS recipient\n        ON ta.recipient_id=recipient.u_id\n        JOIN users AS sender\n        ON ta.sender_id=sender.u_id\n        WHERE ta.sender_id =111111 OR ta.recipient_id = 111111\n        LIMIT 0 , 10