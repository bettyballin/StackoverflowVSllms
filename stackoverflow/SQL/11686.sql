SELECT\n    highest_priority_messages.*\nFROM\n(\n    SELECT\n    m.MessageID\n    , m.CategoryID\n    , m.Priority\n    , m.MessageText\n    , Rank() OVER \n        (PARTITION BY m.CategoryID ORDER BY m.Priority DESC) AS p_rank\n    FROM [Message] m\n    GROUP BY \n        m.CategoryID \n        , m.Priority\n        , m.MessageID\n        , m.MessageText\n) highest_priority_messages\nWHERE \n    p_rank = 1