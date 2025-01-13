public function userProposals() {\n    $username = User::getUsername();\n    $state = User::userState();\n    $tables = [\n        'petition' => 'Petition',\n        'proposition' => 'Proposition',\n        'amendment' => 'Amendment',\n    ];\n\n    $conn = new mysqli("your_host", "your_user", "your_pass", "your_db");\n\n    foreach ($tables as $table => $type) {\n        $sql = "SELECT * FROM $table WHERE author = ?";\n        $stmt = $conn->prepare($sql);\n        $stmt->bind_param("s", $username);\n        $stmt->execute();\n        $result = $stmt->get_result();\n        while ($row = $result->fetch_assoc()) {\n            echo "\n            <tr>\n                <td>$row[id]</td>\n                <td><a href='viewproposal.php?type=$table&id=$row[id]'>$row[title]</a></td>\n                <td>$type</td>\n                <td>$state</td>\n            </tr>";\n        }\n    }\n}