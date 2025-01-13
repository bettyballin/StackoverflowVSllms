SELECT \n    bk.*, \n    bc.books_sold\nFROM \n    books_book bk\nINNER JOIN \n    (\n        SELECT \n            bk2.id_book, \n            COUNT(*) books_sold\n        FROM \n            books_book bk2 \n        INNER JOIN \n            orderdetails_orddetails ord ON bk2.id_book = ord.id_book_orddetails\n        GROUP BY \n            bk2.id_book\n    ) bc ON bk.id_book = bc.id_book\nORDER BY \n    books_sold DESC