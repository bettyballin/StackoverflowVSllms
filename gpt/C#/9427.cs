var groupsWithoutPeople = from g in context.Groups\n                          join p in context.People on g.GroupId equals p.GroupId into gj\n                          from subp in gj.DefaultIfEmpty()\n                          where subp == null\n                          select g;