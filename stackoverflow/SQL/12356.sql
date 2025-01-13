select s1.username || '@' || s1.machine    || ' ( SID=' || s1.sid || ' ) is blocking '\n  || s2.username || '@' || s2.machine || ' ( SID=' || s2.sid || ' ) ' AS blocking_status\n  from v$lock l1, v$session s1, v$lock l2, v$session s2\n  where s1.sid=l1.sid and s2.sid=l2.sid\n  and l1.BLOCK=1 and l2.request > 0\n  and l1.id1 = l2.id1\n  and l2.id2 = l2.id2