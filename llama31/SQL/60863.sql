SELECT l.* \nFROM lists l \nJOIN words w ON l.id = w.list_id \nWHERE w.word = 'search_word';