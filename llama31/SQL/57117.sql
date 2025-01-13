CREATE TRIGGER trg_nolock_support_team\nON ALL SERVER\nFOR LOGON\nAS\nBEGIN\n    IF ORIGINAL_LOGIN() = 'support_team_login'\n    BEGIN\n        SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;\n    END\nEND;