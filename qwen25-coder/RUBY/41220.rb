item = Item.create(name: "Sample Item")\norder = Order.create(profit: 15.75)\n\n# Add item to the order directly through association\ntran_item = order.tran_items.build(item_id: item.id, quantity: 3)\ntran_item.save