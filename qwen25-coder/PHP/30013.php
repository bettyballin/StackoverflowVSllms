<!-- application/views/cart_view.php -->\n   <h1>Your Shopping Cart</h1>\n   <?php if (!empty($cart_items)): ?>\n       <ul>\n           <?php foreach ($cart_items as $item): ?>\n               <li>Product ID: <?= htmlspecialchars($item['product_id']) ?>, Quantity: <?= htmlspecialchars($item['quantity']) ?></li>\n           <?php endforeach; ?>\n       </ul>\n   <?php else: ?>\n       <p>Your cart is empty.</p>\n   <?php endif; ?>