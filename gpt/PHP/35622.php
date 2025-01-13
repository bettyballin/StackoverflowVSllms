<?php\nfunction smarty_block_products($params, $content, Smarty_Internal_Template $template, &$repeat)\n{\n    // Database connection parameters\n    $host = 'your_database_host';\n    $dbname = 'your_database_name';\n    $username = 'your_database_username';\n    $password = 'your_database_password';\n\n    // Create a new PDO connection\n    $pdo = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    if (is_null($content)) {\n        // First pass, set up the query\n        $category = $params['category'];\n        $stmt = $pdo->prepare('SELECT * FROM products WHERE category = :category');\n        $stmt->execute(['category' => $category]);\n        $template->assign('products', $stmt->fetchAll(PDO::FETCH_ASSOC));\n        $repeat = true;\n    } else {\n        // Subsequent passes, process each product\n        static $products;\n        if (!isset($products)) {\n            $products = $template->getTemplateVars('products');\n        }\n\n        if (count($products) > 0) {\n            $product = array_shift($products);\n            $template->assign('product', $product);\n            $repeat = true;\n        } else {\n            $repeat = false;\n        }\n    }\n\n    return $content;\n}