CREATE TABLE [TESTTABLE]\n(\n    [ID] [int] IDENTITY(1,1) NOT NULL,\n    [DateField] [datetime2(3)] NULL,  -- Use datetime2 with precision of 3 to match millisecond precision\n    [StringField] [varchar](50),\n    [IntField] [int] NULL,\n    [BitField] [bit] NULL\n);\n\nBEGIN \n   INSERT INTO TESTTABLE (IntField, BitField, StringField, DateField) \n   VALUES ('1', 1, 'hello', {ts '2009-04-03 15:41:27.378'});  \n\n   SELECT SCOPE_IDENTITY();  \nEND\n\nSELECT * FROM TESTTABLE WITH (NOLOCK);