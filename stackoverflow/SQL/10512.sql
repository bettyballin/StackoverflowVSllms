SQL> select (select count(*) from emp2 where empdeptno = deptno)\n  2  from dept\n  3  where deptno=10\n  4  /\n\n(SELECTCOUNT(*)FROMEMP2WHEREEMPDEPTNO=DEPTNO)\n---------------------------------------------\n                                            3