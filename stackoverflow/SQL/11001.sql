SELECT \n    np.Id, \n    np.Description, \n    MIN(Case promotionalCode WHEN 'A' THEN Price ELSE NULL END) AS 'A',\n    MIN(Case promotionalCode WHEN 'B' THEN Price ELSE NULL END) AS 'B',\n    MIN(Case promotionalCode WHEN 'C' THEN Price ELSE NULL END) AS 'C'\nFROM \n    Price AS p \nINNER JOIN nProduct AS np ON p.nProduct = np.Id\nGROUP BY \n    np.Id,\n    np.Descriptio