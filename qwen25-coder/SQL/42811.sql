WITH MaxResponses AS (\n    SELECT Question, MAX(Responses) AS MaxResp\n    FROM mytable\n    GROUP BY Question\n)\nSELECT t.Question, t.Answer, t.Responses\nFROM mytable t\nJOIN MaxResponses m ON t.Question = m.Question AND t.Responses = m.MaxResp;