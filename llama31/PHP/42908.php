line     #* E I O op                           fetch          ext  return  operands\n-------------------------------------------------------------------------------------\n   2     0  E >   EXT_STMT\n         1        ASSIGN_REF                               $fu\n         2        ASSIGN_REF                               $bah\n   3     3      > JMPZ                                       ~0\n   4     4    >   EXT_STMT\n         5        FETCH_OBJ_R                      $fu\n         6        OBJ_CALL                                  $fu, 'doSomething'\n   6     7        EXT_STMT\n         8        FETCH_OBJ_R                      $bah\n         9        OBJ_CALL                                  $bah, 'doSomething'\n  10    10      > RETURN