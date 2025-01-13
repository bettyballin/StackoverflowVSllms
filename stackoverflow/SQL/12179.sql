select a.id\nfrom Articles a \ninner join ArticleKeywords ak on ak.articleid = a.id\ninner join Keywords k on k.id = ak.keywordid\ngroup by a.id\nhaving \n    sum(case when k.name in ('a1') then 1 else 0 end) = 1\n    or sum(case when k.name in ('b1','b2') then 1 else 0 end) = 2 \n    or sum(case when k.name in ('c1','c2,'c3') then 1 else 0 end) > 0