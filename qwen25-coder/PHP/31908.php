<?php\nfunction getmails() {\n    // Use mysqli instead of mysql for better security and future-proofing\n    $conn = mysqli_connect("localhost", "username", "password", "database") or die(mysqli_error($conn));\n    \n    $result = mysqli_query($conn, "SELECT * FROM subscribes ORDER BY subscribe_id DESC") or die(mysqli_error($conn));\n    $elements = array();\n    while ($row = mysqli_fetch_assoc($result)) {\n        $elements[] = $row['subscribe_email'];\n    }\n    mysqli_close($conn);\n    \n    return implode(', ', $elements);\n}\n\nfunction announce() {\n    if (isset($_POST['announce'])) {\n        // Sanitize inputs to prevent header injection attacks\n        $toEmail = getmails();\n        $emailSubject = filter_var($_POST['title'], FILTER_SANITIZE_STRING);\n        $from = filter_var($_POST['author'] . "@subdomain.domain.com", FILTER_SANITIZE_EMAIL);\n\n        $mailHeader = "From: newsletter@subdomain.domain.com\r\n";\n        $mailHeader .= "Reply-To: {$from}\r\n";\n        $mailHeader .= "Content-type: text/html; charset=iso-8859-1\r\n";\n\n        $messageBody = "Author: " . filter_var($_POST['author'], FILTER_SANITIZE_STRING) . "<br>";\n        $messageBody .= "Newsletter: " . nl2br(filter_var($_POST['content'], FILTER_SANITIZE_STRING)) . "<br>";\n\n        if (mail($toEmail, $emailSubject, $messageBody, $mailHeader)) {\n            echo "Email sent successfully!";\n        } else {\n            die("Failure");\n        }\n    }\n}\n?>