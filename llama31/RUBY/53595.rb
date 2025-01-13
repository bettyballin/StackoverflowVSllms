class Book < ApplicationRecord\n  def self.complex_query(date1, date2, date3)\n    find_by_sql([\n      "SELECT * FROM books\n       INNER JOIN carts ON carts.book_id = books.id\n       WHERE created_at BETWEEN ? AND ? AND updated_at <= ?",\n      date1, date2, date3\n    ])\n  end\nend