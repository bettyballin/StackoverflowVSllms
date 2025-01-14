set aid random(1, 100000 * :scale)\n\set bid random(1, 1 * :scale)\n\set tid random(1, 10 * :scale)\n\set delta random(-5000, 5000)\n\nBEGIN;\nUPDATE accounts SET balance = balance + :delta WHERE aid = :aid;\nSELECT abalance FROM accounts WHERE aid = :aid;\nUPDATE tellers SET tbalance = tbalance + :delta WHERE tid = :tid;\nUPDATE branches SET bbalance = bbalance + :delta WHERE bid = :bid;\nINSERT INTO history (tid, bid, aid, delta, mtime) VALUES (:tid, :bid, :aid, :delta, CURRENT_TIMESTAMP);\nEND;