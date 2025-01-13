SELECT sum(reviews.rev_rating)/count(reviews.rev_id) as avg_rating, ...\nFROM ...\nGROUP BY ...\nHAVING sum(reviews.rev_rating)/count(reviews.rev_id) > x;