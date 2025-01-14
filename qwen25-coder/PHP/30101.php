if ($_SERVER['REQUEST_METHOD'] === 'OPTIONS') {\n    // Allow all domains (you can restrict this!)\n    header('Access-Control-Allow-Origin: *');\n    \n    // Specify which methods are allowed for your resource\n    header('Access-Control-Allow-Methods: POST, GET, OPTIONS');\n    \n    // Set the headers that are allowed to be sent with a request\n    header('Access-Control-Allow-Headers: X-Requested-With, Content-Type');\n\n    // No need to output anything, the script should end here\n    exit;\n}\n\n// Handle actual requests (POST/GET) here\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    $data = json_decode($_POST["json"], true);\n    if ($data['method'] === "getStates" && $data['program'] === "EXPLORE") {\n        // Process the request and send a response\n        echo json_encode(['states' => ['State1', 'State2']]);\n    }\n}