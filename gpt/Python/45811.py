# Example of combining results for goodness\nfinal_rank = goodness_rank_by_flavor.groupby('bakery')['goodness_score'].mean().sort_values(ascending=False).reset_index()\n\n# Top-ranked bakery for goodness\ntop_bakery_goodness = final_rank.iloc[0]\nprint(top_bakery_goodness)