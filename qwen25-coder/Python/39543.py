from django.db import connection\n\ndef full_outer_join_books_authors():\n    with connection.cursor() as cursor:\n        cursor.execute("""\n            SELECT a.name AS author_name, b.title AS book_title\n            FROM author a\n            FULL OUTER JOIN book_authors ba ON a.id = ba.author_id\n            FULL OUTER JOIN book b ON ba.book_id = b.id;\n        """)\n        rows = cursor.fetchall()\n    return rows\n\nprint(full_outer_join_books_authors())