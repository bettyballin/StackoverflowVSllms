if (isset($_GET['rft_id']) && is_array($_GET['rft_id'])) {\n    foreach ($_GET['rft_id'] as $id) {\n        echo "ID: " . htmlspecialchars($id) . "<br>";\n    }\n}