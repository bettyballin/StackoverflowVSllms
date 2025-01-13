CREATE VIEW pivmehis WITH ENCRYPTION\nAS\nSELECT \n    MAX(CASE WHEN MgtApproval = 'Approved' THEN SchedId END) AS Approved,\n    MAX(CASE WHEN MgtApproval = 'Reject' THEN SchedId END) AS Reject,\n    MAX(CASE WHEN MgtApproval IS NULL THEN SchedId END) AS [Null]\nFROM \n    (SELECT \n        MgtApproval,\n        SchedId,\n        ROW_NUMBER() OVER (PARTITION BY MgtApproval ORDER BY SchedId) AS rn\n     FROM LeaveRequest) AS l\nGROUP BY rn;