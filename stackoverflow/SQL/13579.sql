select column1 from tableWithProperCollation\nunion all\nselect column1 COLLATE SQL_Latin1_General_CP1_CI_AS from tableWithDifferentCollatio