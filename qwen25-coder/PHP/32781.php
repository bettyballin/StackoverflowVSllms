<?php\n   if ($_SERVER['REQUEST_METHOD'] === 'POST') {\n       $order = isset($_POST['order']) ? $_POST['order'] : [];\n       // Process the order array, e.g., save it to a user's settings in the database.\n       \n       foreach ($order as $index => $portletId) {\n           // Update your database with the new order for the specific portlet ID\n           // Example: update_order_in_database($userId, $portletId, $index);\n       }\n       \n       echo json_encode(['status' => 'success']);\n   }\n   ?>