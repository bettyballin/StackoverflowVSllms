CREATE PROCEDURE app1_get_user_details\n    @user_id INT\nAS\nBEGIN\n    EXEC common_get_user_by_id @user_id\n    -- Additional logic specific to app1\nEND\nGO