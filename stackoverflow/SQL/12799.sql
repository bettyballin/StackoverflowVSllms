UPDATE Table AS target\nINNER JOIN \n(\nselect category, appearances_sum\nfrom Table T inner join (\n    select category as cat, sum(appearances) as appearances_sum\n    from Table\n    group by cat\n) as agg\nwhere T.category  = agg.cat\ngroup by category\n) as source\nON target.category = source.category\nSET target.probability = target.appearances / source.appearances_sum 