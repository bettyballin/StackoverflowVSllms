from django.shortcuts import render\n   from .models import Order, Item\n   from django.db.models import Sum, F\n\n   def generate_report(request):\n       orders = Order.objects.all().prefetch_related('items')\n       report_data = []\n\n       for order in orders:\n           items = order.items.all()\n           subtotal_qty = items.aggregate(total_qty=Sum('quantity'))['total_qty']\n           subtotal_qty_sold = items.aggregate(total_qty_sold=Sum('quantity_sold'))['total_qty_sold']\n           subtotal_cost = items.aggregate(total_cost=Sum('cost'))['total_cost']\n           subtotal_cost_value = sum(item.cost_value() for item in items)\n\n           report_data.append({\n               'order': order,\n               'items': items,\n               'subtotal_qty': subtotal_qty,\n               'subtotal_qty_sold': subtotal_qty_sold,\n               'subtotal_cost': subtotal_cost,\n               'subtotal_cost_value': subtotal_cost_value,\n           })\n\n       return render(request, 'report.html', {'report_data': report_data})