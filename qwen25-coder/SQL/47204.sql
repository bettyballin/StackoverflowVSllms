BEGIN TRANSACTION;\n\n-- Delete the task first (assuming you have already done this)\nDELETE FROM Tasks WHERE TaskId = @DeletedTaskId;\n\n-- Reorder tasks\nWITH CTE AS (\n    SELECT TaskId, ParentTaskId, TaskOrder,\n           ROW_NUMBER() OVER (\n               PARTITION BY ParentTaskId \n               ORDER BY CASE WHEN TaskId = @DeletedTaskId THEN 1 ELSE 0 END ASC, TaskOrder ASC) AS NewOrder\n    FROM Tasks\n    WHERE ParentTaskId = (SELECT ParentTaskId FROM Tasks WHERE TaskId = @DeletedTaskId)\n)\nUPDATE CTE\nSET TaskOrder = NewOrder - 1\nWHERE NewOrder > 1;\n\nCOMMIT TRANSACTION;