int[] buildingIDs = new int[] { 1, 2, 3 };\n\n/***/ @"SELECT id, startDateTime, endDateTime From tb_bookings WHERE buildingID IN (" +\n      string.Join(", ", buildingIDs.Select(id => id.ToString()).ToArray())\n      + ") AND startDateTime <= @fromDate"; 