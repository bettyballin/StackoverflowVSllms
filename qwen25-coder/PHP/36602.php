$query = "SELECT * \nFROM produto \nINNER JOIN pt ON produto.refPT = pt.ref \nWHERE produto.refPT IN (SELECT idProduto FROM amb_prod WHERE idAmbiente = '1')";\n\n$result_set = mysql_query($query);\n\nif (!$result_set) {\n    die('Invalid query: ' . mysql_error());\n}\n\nwhile ($row = mysql_fetch_array($result_set)) {\n    // Process the row\n}