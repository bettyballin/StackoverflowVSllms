import pandas as pd\n\ndef get_active_users_by_day():\n    query = "SELECT DATE(activity_time) AS date, COUNT(DISTINCT user_id) AS active_users FROM UserActivity GROUP BY DATE(activity_time)"\n    df = pd.read_sql_query(query, engine)\n    return df