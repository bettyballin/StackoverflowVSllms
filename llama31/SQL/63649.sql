UPDATE Orders\nSET Ordernumber = FORMAT(CONVERT(INT, Ordernumber), 'D6')