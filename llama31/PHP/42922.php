line     #* E I O op                           fetch          ext  return  operands\n-------------------------------------------------------------------------------------\n   2     0  E >   EXT_STMT\n         1        JMPZ                                       ~0\n   3     2    >   EXT_STMT\n         3        ASSIGN_REF                               $fu\n         4        FETCH_OBJ_R                      $fu\n         5        OBJ_CALL                                  $fu, 'doSomething'\n   6     6        EXT_STMT\n         7        ASSIGN_REF                               $bah\n         8        FETCH_OBJ_R                      $bah\n         9        OBJ_CALL                                  $bah, 'doSomething'\n  10    10      > RETURN