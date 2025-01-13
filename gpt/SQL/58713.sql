SELECT \n    RunOutDate, \n    ResupplyDate,\n    (DATE_TRUNC('day', ResupplyDate) - DATE_TRUNC('day', RunOutDate)) / INTERVAL '1 day' + 1 AS DaysUnavailable\nFROM \n    FuelOutage;