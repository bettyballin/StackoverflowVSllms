SELECT *\nFROM yourdatabasename.sys.all_objects\nWHERE upper(name) like upper('my prefix%')  --use UPPER for case-INsensitivity