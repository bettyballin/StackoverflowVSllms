$sth = mysql_query(\n    sprintf(\n            "SELECT c_id,p_id,p_title FROM projects WHERE c_id = '%s'",\n            mysql_real_escape_string($_GET['id'])\n    )\n);