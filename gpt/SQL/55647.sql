SELECT * \n   FROM [Service Schedule]\n   WHERE ID=2 \n     AND Trim(Volume) <= 3000 \n     AND Term='Monthly'\n     AND special = 'Regular'\n   ORDER BY Volume