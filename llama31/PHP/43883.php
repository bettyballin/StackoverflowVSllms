$count_sql = preg_replace("/SELECT(.+?)FROM/s", "SELECT COUNT(*) FROM", $sql);