SELECT * \nFROM sys.dm_exec_query_stats \nWHERE transaction_id = <transactionID>;