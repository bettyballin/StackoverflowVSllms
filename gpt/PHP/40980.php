function addToCart($productId, $quantity) {\n    // Check if the cart already exists in the session\n    if (!isset($_SESSION['cart'])) {\n        $_SESSION['cart'] = [];\n    }\n\n    // Check if the product is already in the cart\n    if (isset($_SESSION['cart'][$productId])) {\n        $_SESSION['cart'][$productId] += $quantity;\n    } else {\n        $_SESSION['cart'][$productId] = $quantity;\n    }\n}\n\n// Example usage\naddToCart(1, 2);