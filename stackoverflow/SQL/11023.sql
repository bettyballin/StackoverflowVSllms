SQL> create table mastertable (id number(10) not null primary key);\n\nSQL> create table tablea\n(id number(10) not null primary key\n, master_id number(10) not null references mastertable (id));\n\nSQL> create table tableb\n(id number(10) not null primary key\n, master_id number(10) not null references mastertable (id));\n\nSQL> create table tablec\n(id number(10) not null primary key\n, master_id number(10) not null references mastertable (id));