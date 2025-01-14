from django.db.models import OuterRef, Subquery, Max\n\n# Subquery to get the contract with the maximum current_price for each market\nsubquery = Contract.objects.filter(\n    market=OuterRef('pk')\n).order_by('-current_price').values('pk')[:1]\n\n# Annotate the market with the contract having the maximum current_price\nmarkets = Market.objects.annotate(\n    max_contract_id=Subquery(subquery)\n).select_related('contract_set')\n\n# Fetch the markets along with the contract with the maximum price\nfor market in markets:\n    max_contract = market.contract_set.get(pk=market.max_contract_id)\n    print(market.name, max_contract.name, max_contract.current_price)