SELECT \n    e.name, \n    STUFF((SELECT ';' + p.email \n           FROM PERSON p2 \n           WHERE p2.agentofrecord_id = e.employee_id \n           AND dbo.GetPersonMember(p2.person_id) = 1 \n           AND p2.isactive = 1 \n           AND p2.email <> '' \n           FOR XML PATH('')), 1, 1, '') AS email_addresses\nFROM \n    EMPLOYEE e\nORDER BY \n    e.name