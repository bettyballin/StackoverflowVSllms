[SqlProcedure]\npublic static bool ValidateScore(int score)\n{\n    try\n    {\n        new Score(score);\n        return true;\n    }\n    catch (Exception ex)\n    {\n        SqlContext.Pipe.Send(ex.Message);\n        return false;\n    }\n}