DROP FULLTEXT INDEX ON YourTable;\n   \n   CREATE FULLTEXT INDEX ON YourTable\n   (\n       YourColumn1 LANGUAGE 'English',\n       YourColumn2 LANGUAGE 'English'\n   )\n   KEY INDEX YourPrimaryKeyIndex\n   WITH CHANGE_TRACKING AUTO;