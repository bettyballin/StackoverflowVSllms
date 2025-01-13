select min(a.transaction_date), a.account from\n\n(select sum(t1.points) as thesum, t2.transaction_date, t2.account \nfrom table t1\ninner join table t2 on t1.account = t2.account and t1.transaction_date <= t2.transaction_date\ngroup by t2.transaction_date, t2.account\nhaving thesum >= 100) a \n\ngroup by a.account