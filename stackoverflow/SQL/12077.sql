select  item.name \nfrom    item \nwhere   item.attribute in ('4 legs', 'green') \ngroup by item.name \nhaving  count(distinct item.attribute) = 2