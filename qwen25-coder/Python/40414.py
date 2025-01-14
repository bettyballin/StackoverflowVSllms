from storm.locals import *\n\nclass Order(SQLObject):\n    class sqlmeta:\n        table = 'orders'\n    ordering_person = UnicodeCol()\n    date = DateTimeCol()\n\nclass Product(SQLObject):\n    class sqlmeta:\n        table = 'products'\n    name = UnicodeCol()\n\nclass OrderItem(SQLObject):\n    class sqlmeta:\n        table = 'order_items'\n        joinColumn = "order_id"\n        otherColumn = "product_id"\n        joinKeyword = "order"\n        otherKeyword = "product"\n    order = ForeignKey("Order", default=None)\n    product = ForeignKey("Product", default=None)\n    quantity = IntCol()\n\n# Example usage:\n# Create orders, products, and associate them with quantities\norder1 = Order(ordering_person=u"John Doe", date=datetime.now())\negg = Product(name=u"Egg")\nbread = Product(name=u"Bread")\n\nOrderItem(order=order1, product=egg, quantity=3)\nOrderItem(order=order1, product=bread, quantity=2)