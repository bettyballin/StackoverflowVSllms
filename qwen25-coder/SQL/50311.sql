SELECT \n    `orders`.*,\n    GROUP_CONCAT(\n        CASE \n            WHEN `menu_items`.`price` > 0 THEN \n                CONCAT(\n                    `menu_items`.`name`, \n                    ' ($',\n                    FORMAT(`menu_items`.`price`,2),\n                    ')'\n                )\n            ELSE \n                `menu_items`.`name`\n        END SEPARATOR '<br>'\n    ) as `items`,\n    SUM(`menu_items`.`price`) as `additional`,\n    `children`.`first_name`,\n    `children`.`last_name`,\n    `organizations`.`base_price`\nFROM \n    `orders`, `order_items`, `menu_items`, `children`, `organizations`\nWHERE \n    `order_items`.`menu_item_id` = `menu_items`.`id` AND \n    `order_items`.`order_id` = `orders`.`id` AND\n    `orders`.`added_by` = {$user_id} AND\n    `orders`.`date` > '{$cutoff}' AND\n    `children`.`id` = `orders`.`child_id` AND\n    `organizations`.`id` = `children`.`organization_id`\nGROUP BY \n    `orders`.`id`;