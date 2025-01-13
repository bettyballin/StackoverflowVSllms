query = from p in context.PROJECTS\n        where (from n in context.PROJECT_NOTES\n               where n.NOTES.Contains(cwForm.search1Form) && n.PROJECT_ID == p.PROJECT_ID\n               select n).Any()\n        select p;