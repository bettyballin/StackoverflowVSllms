function getUnreadThreadIDsForUser($userId) {\n    global $conn;\n    $query = "SELECT T.ThreadID \n              FROM Threads AS T \n              LEFT JOIN UserReadThreads AS URT ON T.ThreadID = URT.ThreadID AND URT.UserID = ?\n              WHERE URT.LastReadDateTime IS NULL OR URT.LastReadDateTime < T.LastPostDateTime";\n    $stmt = $conn->prepare($query);\n    if ($stmt === false) { die('Prepare statement failed'); }\n    $stmt->bind_param("i", $userId);\n    $stmt->execute();\n    $result = $stmt->get_result();\n    $unreadThreadIDs = array();\n    while ($row = $result->fetch_assoc()) {\n        $unreadThreadIDs[] = $row['ThreadID'];\n    }\n    return $unreadThreadIDs;\n}