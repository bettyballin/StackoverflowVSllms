selectcommand="SELECT THING1, THING2 FROM DATA_TABLE WHERE (THING2 IN (SELECT THING2 FROM RELATED_DATA_TABLE WHERE (USERNAME = :user)))"