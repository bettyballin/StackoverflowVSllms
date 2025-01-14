merge into data \nusing (\n    select 'someid' as id, 'testKey' as key, 'someValue' as value from dual\n) src\non (data.id = src.id and data.key = src.key)\nwhen matched then \n    update set value = src.value \nwhen not matched then \n    insert (id, key, value) values (src.id, src.src, src.value);