<?php $product = $block->getProduct(); ?>\n<div class="product-dates">\n    <p><strong>Created At:</strong> <?= $block->escapeHtml($product->getCreatedAt()) ?></p>\n    <p><strong>Last Updated At:</strong> <?= $block->escapeHtml($product->getUpdatedAt()) ?></p>\n</div>