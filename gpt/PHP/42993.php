$results = Article::whereRaw("MATCH(title, body) AGAINST(? IN BOOLEAN MODE)", [$query])->get();