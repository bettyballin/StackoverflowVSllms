with vars as (\n  select '&aVariable' as a_var from dual\n)\nselect * \nfrom A_TABLE \nwhere A_COLUMN = (select a_var from vars)\nunion\nselect * \nfrom A_TABLE \nwhere B_COLUMN = (select a_var from vars);