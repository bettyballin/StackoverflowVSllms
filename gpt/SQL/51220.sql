CREATE OR REPLACE VIEW FOO_VIEW AS\n    SELECT column1, column2, column3  -- List all columns except BLOB\n    FROM FOO;