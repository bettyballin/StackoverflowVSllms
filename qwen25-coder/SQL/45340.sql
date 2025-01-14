SELECT \n    SUSP.Susp_Visits.SuspReason, \n    SUSP.Susp_Visits.SiteID,\n    COUNT(DATA.Dim_Member.MembershipNum) AS MemberCount\nFROM\n    SUSP.Susp_Visits \nLEFT OUTER JOIN\n    DATA.Dim_Member ON SUSP.Susp_Visits.MemID = DATA.Dim_Member.MembershipNum\nGROUP BY\n    SUSP.Susp_Visits.SuspReason, \n    SUSP.Susp_Visits.SiteID;