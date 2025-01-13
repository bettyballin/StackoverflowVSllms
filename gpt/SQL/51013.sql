-- Assuming you have a way to determine the dynamic database name\nDECLARE @DatabaseName AS varchar(50)\nSET @DatabaseName = 'celcat200809' -- Example, you might set this dynamically\n\n-- Query to concatenate tutor names for each event_id\nSELECT \n    event_id,\n    STUFF(\n        (SELECT ' + ' + name\n         FROM (\n             SELECT CT_EVENT_STAFF.event_id, CT_EVENT_STAFF.weeks, \n                    CT_STAFF.unique_name, CT_STAFF.name\n             FROM [dbo].[CT_EVENT_STAFF] AS CT_EVENT_STAFF \n             LEFT OUTER JOIN [dbo].[CT_STAFF] AS CT_STAFF \n             ON CT_EVENT_STAFF.staff_id = CT_STAFF.staff_id\n             WHERE CT_EVENT_STAFF.event_id = e.event_id\n             ) AS inner_query\n         FOR XML PATH(''), TYPE).value('.', 'varchar(max)'), 1, 3, '') AS Tutors\nFROM \n    [dbo].[CT_EVENT_STAFF] AS e\nGROUP BY \n    event_id