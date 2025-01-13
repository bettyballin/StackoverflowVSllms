SELECT\n  v.[VISITDATE], \n  CONVERT(VARCHAR, v.[STARTTIME], 105) AS 'Startdate', \n  CONVERT(VARCHAR, v.[STARTTIME], 108) AS 'StartTime', \n  CONVERT(VARCHAR, v.[bookeddate], 105) AS 'BookedDate', \n  CONVERT(VARCHAR, t.[starttime], 108) AS 'TimeSlotStart', \n  CONVERT(VARCHAR, t.[endtime], 108) AS 'TimeSlotEnd',\n  v.[Status],\n  CASE\n    WHEN v.[STARTTIME] >= t.[starttime] AND v.[STARTTIME] < t.[endtime] THEN 'True'\n    ELSE 'False'\n  END AS 'IsInTimeSlot'\nFROM\n  [tbl_repair_visit] v \n  INNER JOIN [ltbl_TimeSlots] t ON v.timeslot = t.[Slot]