@DateValue datetime\n\nselect * \nfrom table\nwhere field1 = 'x'\nand field2 = 'y'\nand field3 = CASE \n                WHEN @DateValue = '1/1/1900' THEN field3 <= getdate()\n                ELSE @DateValue\n             END