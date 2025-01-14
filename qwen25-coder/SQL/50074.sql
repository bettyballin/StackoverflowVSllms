ALTER PROCEDURE [dbo].[ALLOCATE_BUDGET] \n    @budget_scenario_id uniqueidentifier\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    DECLARE @constraint_type varchar(25)\n\n    BEGIN TRANSACTION;\n        SAVE TRANSACTION StartSavePoint;\n\n        -- get project cache id and constraint type\n        SELECT @constraint_type = CONSTRAINT_TYPE\n        FROM BUDGET_SCENARIO WHERE BUDGET_SCENARIO_ID = @budget_scenario_id\n\n        -- Execute the appropriate sub-stored procedure based on the constraint type\n        IF (@constraint_type = 'Region by Region')\n            EXEC BUDGET_ALLOCATE_SCENARIO_REGIONBYREGION @budget_scenario_id\n\n        ELSE IF (@constraint_type = 'City Wide')\n            EXEC BUDGET_ALLOCATE_SCENARIO_CITYWIDE @budget_scenario_id\n\n        ELSE IF (@constraint_type = 'Do Nothing')\n            EXEC BUDGET_ALLOCATE_SCENARIO_DONOTHING @budget_scenario_id\n\n        ELSE IF (@constraint_type = 'Unconstrained')\n            EXEC BUDGET_ALLOCATE_SCENARIO_UNCONSTRAINED @budget_scenario_id\n\n        -- If all goes well, update the budget scenario status\n        EXEC BUDGET_UPDATE_SCENARIO_STATUS @budget_scenario_id, 'Allocated'\n\n    COMMIT TRANSACTION;\nEND