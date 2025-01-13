if exists (\n  select *\n  from MyUserList\n  where IsAdmin = 1\n    and UserName = SUSER_NAME()\n)\nbegin\n  select *\n  from MyUserList /* Or whatever you need to do if the user is admin */\nend\nelse\nbegin\n/* Do whatever you need to do if the user is not an admin */\nend  