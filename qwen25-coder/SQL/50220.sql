SELECT LINE, TEXT\nFROM USER_ERRORS\nWHERE NAME = 'WWV_FLOW_QUERY'\nAND TYPE = 'PACKAGE BODY'\nORDER BY SEQUENCE;