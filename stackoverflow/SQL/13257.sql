select *\n  from employee_schedule a                    \n where not exists( select *                          \n                     from employee_schedule b        \n                    where a.employeeid = b.employeeid\n                      and a.projectid  = b.projectid \n                      and (a.dayid - 1) = b.dayid )