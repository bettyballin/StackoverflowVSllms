var latestWorkplans = from w1 in db.Workplans\n                      where (from w2 in db.Workplans\n                             where w2.UserID == w1.UserID\n                             select w2.CreatedDate).Max() == w1.CreatedDate\n                      select w1;