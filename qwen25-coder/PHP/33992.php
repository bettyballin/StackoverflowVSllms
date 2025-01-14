/***************************************************/\n/* RandomSite */\n//****************/\n//  Returns an array of random site IDs or NULL\n/***************************************************/   \nfunction RandomSite($intNumberofSites = 1) {\n    $arrOutput = null;\n    \n    // Open the database connection using mysqli\n    $conn = new mysqli('host', 'username', 'password', 'database');\n    \n    if ($conn->connect_error) {\n        die("Connection failed: " . $conn->connect_error);\n    }\n    \n    // Get all IDs that qualify\n    $strSQL = "SELECT id FROM site_info WHERE major <> 0;";\n    $result = $conn->query($strSQL);\n\n    if ($result && $result->num_rows > 0) {\n        $arrResult = [];\n        \n        // Fetch all IDs into an array\n        while($row = $result->fetch_row()) {\n            $arrResult[] = $row[0];\n        }\n\n        // Shuffle the array to randomize order\n        shuffle($arrResult);\n\n        // Limit the number of results returned\n        $arrOutput = array_slice($arrResult, 0, $intNumberofSites);\n    }\n    \n    // Close connection\n    $conn->close();\n    \n    return $arrOutput;\n}