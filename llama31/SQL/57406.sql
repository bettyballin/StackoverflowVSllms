SELECT \n  partition_name, \n  partition_text \nFROM \n  SYSPARTITIONSTAT \nWHERE \n  partition_type = 'SRCMBR';