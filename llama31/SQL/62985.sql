SELECT q.*, t.TagName\nFROM Questions q\nLEFT JOIN QuestionTags qt ON q.QuestionId = qt.QuestionId\nLEFT JOIN Tags t ON qt.TagId = t.TagId