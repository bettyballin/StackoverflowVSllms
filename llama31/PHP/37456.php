$conn = imap_open($mailbox, $username, $password);\n$latest = imap_search($conn, 'ALL', 'FROM "example@example.com"');\n$body = imap_fetchbody($conn, $latest, "1", FT_PEEK);\n$body = nl2br($body);\nimap_close($conn);\necho $body;