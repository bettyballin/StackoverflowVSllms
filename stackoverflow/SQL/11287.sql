create table triggertest (id int null, val varchar(20))\nGo\ncreate trigger after  on [dbo].triggertest\nfor Update  \nas\nBegin\n\n    delete tt from triggertest tt inner join \n    inserted i on tt.id = i.id \n    where i.id = 9\n\nEnd\nGO\ninsert into triggertest values (1,'x')\ninsert into triggertest values (2,'y')\nUpdate triggertest set id = 9 where id = 2\nselect * from triggertest\n1, x