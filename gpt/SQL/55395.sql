create table B (\n    a_id int(10) not null,\n    val2 varchar(255),\n    foreign key (a_id) references A(id)\n);