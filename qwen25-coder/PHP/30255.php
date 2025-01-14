<?php\n   // Connect to database\n   $pdo = new PDO('mysql:host=localhost;dbname=real_estate', 'username', 'password');\n\n   // Fetch all subscriptions\n   $stmt = $pdo->query("SELECT * FROM Subscriptions");\n   $subscriptions = $stmt->fetchAll(PDO::FETCH_ASSOC);\n\n   foreach ($subscriptions as $subscription) {\n       $criteria = json_decode($subscription['search_criteria'], true);\n       $userId = $subscription['user_id'];\n\n       // Build the search query based on criteria\n       $query = "SELECT * FROM Offers WHERE 1";\n       if (isset($criteria['category'])) {\n           $query .= " AND category_id IN (" . implode(',', array_map(['$pdo', 'quote'], $criteria['category'])) . ")";\n       }\n       if (isset($criteria['keywords'])) {\n           $query .= " AND title LIKE '%" . $pdo->quote("%" . $criteria['keywords'] . "%") . "'";\n       }\n\n       // Assuming last_checked is a column in Users table to track the last email sent timestamp\n       $stmt = $pdo->prepare("SELECT * FROM Offers WHERE created_at > (SELECT last_checked FROM Users WHERE user_id = :user_id)");\n       $stmt->execute(['user_id' => $userId]);\n       $newOffers = $stmt->fetchAll(PDO::FETCH_ASSOC);\n\n       if (!empty($newOffers)) {\n           // Send email to the user with details of new offers\n           sendNotificationEmail($userId, $newOffers);\n           // Update last checked time in Users table\n           updateLastCheckedTimestamp($pdo, $userId);\n       }\n   }\n\n   function sendNotificationEmail($userId, $offers) {\n       // Logic to send email\n   }\n\n   function updateLastCheckedTimestamp(PDO $pdo, $userId) {\n       $stmt = $pdo->prepare("UPDATE Users SET last_checked = NOW() WHERE user_id = :user_id");\n       $stmt->execute(['user_id' => $userId]);\n   }\n   ?>