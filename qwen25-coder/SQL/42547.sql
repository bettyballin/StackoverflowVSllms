select a, b, c, dbms_crypto.hash(utl_raw.cast_to_raw('HELLO'),3)\n  from my_table;