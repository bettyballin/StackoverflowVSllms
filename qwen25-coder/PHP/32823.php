<?php\nheader('Content-Type: application/json');\n\nif ($_GET['action'] == 'get' && isset($_GET['bookid'])) {\n    $bookid = $_GET['bookid'];\n    \n    // Simulate fetching data from the database\n    $totalValue = 150; // Total value of votes (e.g., sum of all ratings)\n    $votesCount = 20;  // Number of votes\n\n    // Calculate width\n    $width = ($totalValue / $votesCount) * 22;\n\n    echo json_encode(['width' => $width, 'votes' => $votesCount]);\n}\n?>