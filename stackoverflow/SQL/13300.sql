SELECT\n   [delay_start].event_id,\n   SUM(DATEDIFF(second, [delay_start].date, [delay_finish].date))\nFROM\n   event_table AS [delay_start]\nINNER JOIN\n   event_table AS [delay_finish]\n      ON  [delay_finish].event_id = [delay_start].event_id\n      AND [delay_finish].date = (\n                                 SELECT\n                                    MIN(date)\n                                 FROM\n                                    event_table\n                                 WHERE\n                                    event_id = [delay_start].event_id\n                                    AND date > [delay_start].date\n                                    AND event = 'Service Reactivated'\n                                )\nWHERE\n   [delay_start].event = 'Service Delayed'\n   AND [delay_finish].event = 'Service Reactivated'\nGROUP BY\n   [delay_start].event_id