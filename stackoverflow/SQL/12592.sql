insert into pager (PAG_ID,PAG_PARENT,PAG_NAME,PAG_ACTIVE)\n          select 8000,0,'Multi 8000',1 from dual\nunion all select 8001,0,'Multi 8001',1 from dual