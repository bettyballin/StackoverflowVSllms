SELECT `ref_id`, `type`, COUNT(*)\n   FROM `my_table`\n   GROUP BY `ref_id`, `type`\n   HAVING COUNT(*) > 1;