SELECT u.[User], t.Application, t.Task, tl.Description\nFROM SY.Users u\nCROSS JOIN SY.Tasks t\nLEFT OUTER JOIN SY.TaskLevels tl \n    ON t.Application = tl.Application \n    AND t.Task = tl.Task \n    AND t.DftAccessLevel = tl.AccessLevel