// Producer script\n    $message = json_encode(['ip' => 'IP', 'visit_time' => time(), 'http_referer' => 'http_referer']);\n    $queue->send($message);\n\n    // Consumer script\n    while ($message = $queue->receive()) {\n        $data = json_decode($message, true);\n        $query = "INSERT INTO stats_table (ip, visit_time, http_referer) VALUES ('{$data['ip']}', '{$data['visit_time']}', '{$data['http_referer']}')";\n        mysqli_query($connection, $query);\n    }