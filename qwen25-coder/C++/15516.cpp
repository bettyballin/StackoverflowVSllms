double nInt64AsDouble = static_cast<double>(99); // Convert __int64 to double\nSQLBindParameter(hStatement, 1, SQL_PARAM_INPUT,\n                 SQL_C_DOUBLE, SQL_BIGINT, 20, 0, &nInt64AsDouble, sizeof(double), &nStrLen);