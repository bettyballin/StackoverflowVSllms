SELECT * FROM processes WHERE get_hash(foo) = get_hash(:new_blob);