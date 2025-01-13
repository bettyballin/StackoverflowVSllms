SELECT \n    OWNER, \n    NAME, \n    TYPE, \n    LINE, \n    TEXT\nFROM \n    ALL_SOURCE\nWHERE \n    TEXT LIKE '%search_phrase%'\nORDER BY \n    OWNER, \n    NAME, \n    TYPE, \n    LINE;