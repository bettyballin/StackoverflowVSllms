select\n   count(*) as TotalCount,\n   count(s.id) as QualifiedCount\nfrom\n   MyTable a\nleft join\n   MyTable s on s.id = a.id and {some conditions}