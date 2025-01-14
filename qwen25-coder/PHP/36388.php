// Assuming $conn is your IMAP connection and $latest is the ID of the latest email\n\n// Fetch the structure of the email to determine its format and encoding\n$overview = imap_fetch_overview($conn, $latest, 0);\n$message_part = imap_bodystruct($conn, $latest, '1');\n\n// Fetch the raw body\n$body = imap_fetchbody($conn, $latest, "1");\n\n// Check if the email is base64 encoded\nif (strtoupper($message_part->encoding) === 'BASE64') {\n    // Decode it from base64 to text\n    $body = imap_base64($body);\n}\n// If quoted-printable, convert it\nelseif (strtoupper($message_part->encoding) === 'QUOTED-PRINTABLE') {\n    $body = imap_qprint($body);\n}\n\n// Output the body\necho nl2br(htmlentities($body));