EXEC sp_settriggerorder @triggername = 'Club_Update_Trigger', @order = 'First', @stmttype = 'UPDATE'\nEXEC sp_settriggerorder @triggername = 'Coach_Update_Trigger', @order = 'Last', @stmttype = 'UPDATE'