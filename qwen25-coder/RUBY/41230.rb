books_to_consider = Book.joins(:notifications => :notification_type)\n                        .where("books.created_at >= ? AND books.created_at <= ?", min_date, max_date)\n                        .where.not("notification_types.name" => 'type1')