@DateValue datetime\n\nselect * \nfrom table\nwhere field1 = 'x'\nand field2 = 'y'\nand (field3 <= getdate() OR (@DateValue <> '1/1/1900' AND field3 = @DateValue))