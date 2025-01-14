# Create an Item instance\nitem = Item.create(name: "Sample Item")\n\n# Create an Order (Transaction) instance with profit\norder = Order.create(profit: 15.75)\n\n# Add the item to the order using the join model\ntran_item = TranItem.create(item_id: item.id, order_id: order.id, quantity: 3)