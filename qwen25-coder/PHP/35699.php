// Start the session\nsession_start();\n\nfunction addToCart($productId, $quantity) {\n    // Validate input (basic example)\n    if (!is_numeric($productId) || !is_numeric($quantity)) {\n        return false;\n    }\n\n    if (!isset($_SESSION['cart'])) {\n        $_SESSION['cart'] = [];\n    }\n\n    // Add or update product in the cart\n    if (array_key_exists($productId, $_SESSION['cart'])) {\n        $_SESSION['cart'][$productId] += $quantity;\n    } else {\n        $_SESSION['cart'][$productId] = $quantity;\n    }\n}\n\nfunction removeFromCart($productId) {\n    if (isset($_SESSION['cart'][$productId])) {\n        unset($_SESSION['cart'][$productId]);\n    }\n}\n\nfunction getCartContents() {\n    return isset($_SESSION['cart']) ? $_SESSION['cart'] : [];\n}\n\n// Example usage\naddToCart(1, 2);\necho "Cart contents: ";\nprint_r(getCartContents());\nremoveFromCart(1);\necho "\nAfter removal: ";\nprint_r(getCartContents());