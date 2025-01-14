-- Assume @ParentTaskId is the ID of the parent task for which siblings need to be reordered\nDECLARE @ParentTaskId INT;\n\n-- Set the ParentTaskId for which you want to reorder the child tasks\nSET @ParentTaskId = 1;\n\n-- Update TaskOrder for all child tasks under the specified parent\nWITH OrderedTasks AS (\n    SELECT \n        TaskId,\n        ROW_NUMBER() OVER (ORDER BY TaskOrder) AS NewOrder\n    FROM Task\n    WHERE ParentTaskId = @ParentTaskId\n)\nUPDATE Task\nSET TaskOrder = OrderedTasks.NewOrder\nFROM Task\nINNER JOIN OrderedTasks ON Task.TaskId = OrderedTasks.TaskId;