SELECT i.*\nFROM core_item i\nWHERE NOT EXISTS (\n    SELECT 1\n    FROM core_item_in_basket b\n    WHERE b.item_id = i.id AND b.user_id = __some_user__ AND b.on_wishlist IS NOT NULL\n);