declare @seed as int;\nset @seed = 10;\n\ncreate table temp (\nid int,\ndate datetime)\n\ninsert into temp (id, date) values (1,'20090119')\ninsert into temp (id, date) values (2,'20090118')\ninsert into temp (id, date) values (3,'20090117')\ninsert into temp (id, date) values (4,'20090116')\ninsert into temp (id, date) values (5,'20090115')\ninsert into temp (id, date) values (6,'20090114')\n\n-- re-seeds for every item\nselect *, HASHBYTES('md5',cast(id+@seed as varchar)) r\nfrom temp order by r\n--1 2009-01-19 00:00:00.000 0x6512BD43D9CAA6E02C990B0A82652DCA\n--5 2009-01-15 00:00:00.000 0x9BF31C7FF062936A96D3C8BD1F8F2FF3\n--4 2009-01-16 00:00:00.000 0xAAB3238922BCC25A6F606EB525FFDC56\n--2 2009-01-18 00:00:00.000 0xC20AD4D76FE97759AA27A0C99BFF6710\n--3 2009-01-17 00:00:00.000 0xC51CE410C124A10E0DB5E4B97FC2AF39\n--6 2009-01-14 00:00:00.000 0xC74D97B01EAE257E44AA9D5BADE97BAF\n\ndrop table temp