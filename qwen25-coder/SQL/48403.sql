SELECT * \nFROM (  \n    SELECT *, 1 AS SourceOrder FROM xxx WHERE z = 1  \n    UNION  \n    SELECT *, 2 AS SourceOrder FROM xxx WHERE z = 2  \n    UNION  \n    SELECT *, 3 AS SourceOrder FROM xxx WHERE z = 3  \n) subquery\nORDER BY SourceOrder;