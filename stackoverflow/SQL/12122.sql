SELECT dbms_utility.data_block_address_file(\n         to_number(trim(leading '0' from\nreplace('&&rdba','0x','')),'XXXXXXXX')\n       ) AS rfile#,\n       dbms_utility.data_block_address_block(\n         to_number(trim(leading '0' from\nreplace('&&rdba','0x','')),'XXXXXXXX')\n       ) AS block#\nFROM dual;