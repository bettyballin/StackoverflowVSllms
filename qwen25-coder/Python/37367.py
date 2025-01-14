from django.db.models import Avg, Subquery, OuterRef\n\n# Assuming you want the average rank per product, if there's more than one.\ncat = Category.objects.get(pk=1)\n\naverage_product_rank_subquery = ProductRank.objects.filter(\n    product=OuterRef('pk')\n).order_by().values('product').annotate(avg_rank=Avg('rank')).values('avg_rank')\n\nproducts_with_ranks = Product.objects.filter(categories=cat).annotate(\n    average_rank=Subquery(average_product_rank_subquery)\n)