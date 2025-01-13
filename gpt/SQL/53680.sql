declare @p1 varchar(50);\ndeclare @utcDateTime datetime;\n\nset @p1 = '2009-06-26 14:30:00.000-04:00';\n\n-- Extract the datetime part and the offset part\ndeclare @datetimePart varchar(23);\ndeclare @offsetPart varchar(6);\n\nset @datetimePart = substring(@p1, 1, 23);\nset @offsetPart = substring(@p1, 24, 6);\n\n-- Convert the datetime part to datetime type\ndeclare @localDateTime datetime;\nset @localDateTime = cast(@datetimePart as datetime);\n\n-- Convert the offset part to minutes\ndeclare @offsetHours int;\ndeclare @offsetMinutes int;\ndeclare @totalOffsetMinutes int;\n\nset @offsetHours = cast(substring(@offsetPart, 2, 2) as int);\nset @offsetMinutes = cast(substring(@offsetPart, 5, 2) as int);\nset @totalOffsetMinutes = (@offsetHours * 60) + @offsetMinutes;\n\n-- Adjust the offset sign (+ or -)\nif left(@offsetPart, 1) = '-'\nbegin\n    set @totalOffsetMinutes = -@totalOffsetMinutes;\nend\n\n-- Convert the local datetime to UTC\nset @utcDateTime = dateadd(minute, -@totalOffsetMinutes, @localDateTime);\n\nselect @utcDateTime -- should yield '2009-06-26 18:30:00.000'