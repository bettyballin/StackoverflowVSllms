UPDATE Orders\nSET Ordernumber = RIGHT(REPLICATE('0', 6) + Ordernumber, 6);