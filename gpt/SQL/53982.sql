SELECT COUNT(*)\nFROM task_conditionassessment t\nINNER JOIN taskitems_conditionassessment ti ON t.task_conditionassessmentguid = ti.task_conditionassessmentguid\nINNER JOIN conditionassessmentassignmentitem c ON ti.taskitems_conditionassessmentid = c.taskitems_conditionassessmentid\nWHERE t.isactive = 1\nAND (\n    DATEDIFF(dd, c.conditionassessmentdate, t.nextduedate) > 14\n    OR c.conditionassessmentdate IS NULL\n)