DECLARE @userId INT  \nDECLARE @siteId INT\n\nSET @siteId = -1  \nSET @userId = 1828  \n\nWITH SiteList AS (\n    SELECT * \n    FROM dbo.udf_get_event_sitelist(@siteId, @userId)\n)\n\nSELECT  a.id AS alertId,  \n        a.location_id,  \n        a.alert_type_id,  \n        a.event_id,  \n        a.user_id,  \n        a.site_id,  \n        a.accepted_by  \nFROM    alerts AS a    \nJOIN    alert_types AS ats ON a.alert_type_id = ats.id \nJOIN    events AS tr ON a.event_id = tr.event_id \nJOIN    SiteList sl ON a.site_id = sl.siteid\nWHERE   tr.end_Time IS null\nAND     tr.status_id = 0\nAND     ats.code = 'E'