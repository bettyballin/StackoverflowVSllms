create table McTable  (BigMac varchar(255))\n\ninsert into McTable  select '1p927'\ninsert into McTable  select '1927'\ninsert into McTable  select '1,927'\ninsert into McTable  select '1.927'\n\nselect BigMac, isnumeric(BigMac)\nfrom McTable \n\nselect BigMac, CAST(BigMac AS DECIMAL)\nfrom McTable \nwhere isnumeric(BigMac) = 1