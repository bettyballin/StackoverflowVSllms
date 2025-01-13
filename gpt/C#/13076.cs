// Query to fetch questions with tags in a single call\nstring query = @"\n    SELECT q.QuestionId, q.QuestionText, t.TagId, t.TagName\n    FROM Questions q\n    LEFT JOIN QuestionTags qt ON q.QuestionId = qt.QuestionId\n    LEFT JOIN Tags t ON qt.TagId = t.TagId\n";\n\n// Execute the query and get the result\nDataTable dataTable = ExecuteQuery(query);\n\n// Create a dictionary to hold questions and their tags\nDictionary<int, Question> questionsDict = new Dictionary<int, Question>();\n\nforeach (DataRow row in dataTable.Rows)\n{\n    int questionId = (int)row["QuestionId"];\n    string questionText = row["QuestionText"].ToString();\n    \n    if (!questionsDict.ContainsKey(questionId))\n    {\n        questionsDict[questionId] = new Question\n        {\n            QuestionId = questionId,\n            QuestionText = questionText,\n            Tags = new List<Tag>()\n        };\n    }\n\n    if (row["TagId"] != DBNull.Value)\n    {\n        Tag tag = new Tag\n        {\n            TagId = (int)row["TagId"],\n            TagName = row["TagName"].ToString()\n        };\n        questionsDict[questionId].Tags.Add(tag);\n    }\n}\n\n// Bind the dictionary values to a repeater or any other data-bound control\nquestionsRepeater.DataSource = questionsDict.Values;\nquestionsRepeater.DataBind();