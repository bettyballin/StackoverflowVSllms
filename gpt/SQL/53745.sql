SELECT \n    it.TicketID,\n    CONCAT(req.EmployeeFirstName, ' ', req.EmployeeLastName) AS TicketRequesterFullName,\n    CONCAT(appr.EmployeeFirstName, ' ', appr.EmployeeLastName) AS ApprovalManagerFullName,\n    it.RequestDate,\n    it.ApprovalDate,\n    it.TicketStatus\nFROM \n    tblIssueTicket it\nJOIN \n    tblEmployeeProfile req ON it.TicketRequesterID = req.EmployeeID\nJOIN \n    tblEmployeeProfile appr ON it.ApprovalManagerID = appr.EmployeeID;