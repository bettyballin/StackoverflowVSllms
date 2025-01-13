// Assuming you have user input\n   $user_input_item_id = 123;\n   $input_hash = generateHash($user_input_item_id);\n   \n   // Retrieve item details\n   $stmt = $pdo->prepare("SELECT * FROM Items WHERE item_id_hash = ?");\n   $stmt->execute([$input_hash]);\n   $item = $stmt->fetch();\n   \n   if ($item) {\n       echo "Item Name: " . $item['item_name'];\n   } else {\n       echo "Item not found.";\n   }