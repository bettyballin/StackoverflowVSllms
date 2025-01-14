SELECT \n    XMLSERIALIZE(XMLAGG(XMLELEMENT(NAME item, itemName || ',')) AS VARCHAR(1024) REPLACE ALL ',,' WITH '') AS items,\n    SUM(price) AS price\nFROM order_details\nGROUP BY orderid;