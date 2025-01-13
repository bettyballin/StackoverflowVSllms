WITH RecursiveLinkedList AS (\n  SELECT Id, ParentId, SomeData, 0 AS Level\n  FROM LinkedList\n  WHERE ParentId IS NULL  -- anchor query: select the first node\n\n  UNION ALL\n\n  SELECT ll.Id, ll.ParentId, ll.SomeData, Level + 1\n  FROM LinkedList ll\n  JOIN RecursiveLinkedList rll ON ll.ParentId = rll.Id  -- recursive join\n)\nSELECT Id, ParentId, SomeData\nFROM RecursiveLinkedList\nORDER BY Level;