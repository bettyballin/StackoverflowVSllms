UPDATE users\nSET workload = @new_workload\nWHERE user_id = @user_id\n  AND workload = @current_workload;