SELECT f.fid, b.value\nFROM foo f\nLEFT JOIN foo2bar f2b ON f.fid = f2b.fid\nLEFT JOIN bar b ON f2b.bid = b.bid AND b.zid = 30;