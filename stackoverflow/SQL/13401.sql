alter table linked_list add column position integer not null default 0;\n alter table linked_list add index position_index (position);\n select * from linked_list order by position;