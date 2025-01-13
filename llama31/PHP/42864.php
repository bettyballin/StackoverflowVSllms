<?php\n$url = 'https://autotask.com/login'; // Replace with Autotask's login URL\n$clientId = 'your_client_id'; // Replace with your client ID\n\nif ($_SERVER['REQUEST_METHOD'] == 'POST') {\n  $field1 = $_POST['field1'];\n  $field2 = $_POST['field2'];\n  $field3 = $_POST['field3'];\n  $field4 = $_POST['field4'];\n\n  // Create a curl session\n  $ch = curl_init($url);\n\n  // Set the POST data\n  $postData = array(\n    'username' => $field1,\n    'password' => $field2,\n    // Add any other fields you need to forward\n  );\n\n  // Set the client ID in the URL\n  $url .= '?ci=' . $clientId;\n\n  // Set the curl options\n  curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n  curl_setopt($ch, CURLOPT_POST, true);\n  curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($postData));\n\n  // Execute the curl request\n  $response = curl_exec($ch);\n\n  // Close the curl session\n  curl_close($ch);\n\n  // Forward the user to the Autotask client page\n  header('Location: ' . $url);\n  exit;\n}\n?>