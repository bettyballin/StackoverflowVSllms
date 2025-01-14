SELECT lh.ListsId\nFROM ListHasNames lh\nJOIN Names n ON lh.NamesId = n.Id\nWHERE n.Name IN ('Paul', 'Joe', 'Jenny')\nGROUP BY lh.ListsId\nHAVING COUNT(lh.NamesId) = 3\n   AND COUNT(CASE WHEN n.Name = 'Paul' THEN 1 END) = 1\n   AND COUNT(CASE WHEN n.Name = 'Joe' THEN 1 END) = 1\n   AND COUNT(CASE WHEN n.Name = 'Jenny' THEN 1 END) = 1