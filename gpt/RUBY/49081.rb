# Retrieve words using stored IDs\n   word_ids = session[:quiz_word_ids] || []\n   @words = Word.where(id: word_ids)