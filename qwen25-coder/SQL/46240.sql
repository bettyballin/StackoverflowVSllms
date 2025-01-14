SELECT \n    pub.pubid,\n    pub.title,  -- or other relevant fields\n    st.status,\n    pe.name     -- or other relevant fields\nFROM (\n    SELECT spubid as pubid, title FROM articles WHERE keyword LIKE '%your_keyword%' UNION ALL\n    SELECT bpubid as pubid, title FROM books WHERE keyword LIKE '%your_keyword%' UNION ALL\n    SELECT ppubid as pubid, title FROM papers WHERE keyword LIKE '%your_keyword%' -- add other publication types as needed\n) AS pub\nLEFT JOIN status st ON pub.pubid = st.spubid\nLEFT JOIN people pe ON pub.pubid = pe.spubid\nWHERE pe.saffil = 'ABC'\nORDER BY pe.iorder, pub.pubid;