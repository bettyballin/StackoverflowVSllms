INSERT INTO InternalMail (FromID, ToID, FromType, ToType, Message, SentDate)\nVALUES ('some_employee_guid', 'some_company_guid', 'Employee', 'Company', 'Hello from employee!', GETDATE());