SELECT * INTO NewTable FROM OldTable;\n   DROP TABLE OldTable;\n   sp_rename 'NewTable', 'OldTable';