// Set up a PDO connection with UTF-8 charset\n   $options = [\n       PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8mb4',\n       PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,\n   ];\n   $pdo = new PDO('mysql:host=localhost;dbname=yourDatabase;charset=utf8mb4', 'username', 'password', $options);\n\n   // Example of prepared statement\n   $stmt = $pdo->prepare("INSERT INTO table (content) VALUES (:content)");\n   $stmt->execute([':content' => $_POST['userContent']]);\n\n   // Retrieving and outputting data safely\n   $stmt = $pdo->query('SELECT content FROM table');\n   while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {\n       echo htmlentities($row['content'], ENT_QUOTES, 'UTF-8');\n   }