function printPageLinksFirstTry(num totalPages, num currentPage)\n  if ( currentPage > 1 )\n    print "Prev"\n  print "1"\n  print "..."\n  print currentPage - 1\n  print currentPage\n  print currentPage + 1\n  print "..."\n  print totalPages\n  if ( currentPage < totalPages )\n    print "Next"\nendFunctio