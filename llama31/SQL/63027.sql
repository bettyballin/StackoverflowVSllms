ALTER Trigger [dbo].[Set_Asignado_State] ON [dbo].[Tables] \nFOR INSERT AS \nBEGIN      \n    IF TRIGGER_NESTLEVEL() > 1 RETURN\n\n    DECLARE @area varchar(1)\n    SELECT @area = Table_Area_ID FROM inserted\n\n    IF (@area = 'L')\n    BEGIN\n        -- ... rest of your code ...\n    END\nEND