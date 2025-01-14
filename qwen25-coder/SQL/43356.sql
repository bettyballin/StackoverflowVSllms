select \n    a,\n    count(distinct case when b is not null then b end) as distinct_b_count,\n    sum(a) as total_a_sum\nfrom (\n    select 1 a, 1 b union all\n    select 2, 2 union all\n    select 2, null union all\n    select 3, 3 union all\n    select 3, null union all\n    select 3, null\n) as subquery\ngroup by a;