CREATE TABLE swtest (  \n    id          INT IDENTITY,  \n    name        NVARCHAR(20),  \n    deleted_at  DATETIME  \n)  \nGO  \nCREATE TRIGGER tr_swtest_delete ON swtest  \nINSTEAD OF DELETE  \nAS  \nBEGIN  \n    UPDATE swtest SET deleted_at = getDate()  \n    WHERE id IN (SELECT deleted.id FROM deleted)\n    AND deleted_at IS NULL      -- Required to prevent duplicates when deleting already deleted records  \nEND  \nGO  \n\nCREATE UNIQUE INDEX ix_swtest1 ON swtest(name, deleted_at)  \n\nINSERT INTO swtest (name) VALUES ('Thingy1')  \nINSERT INTO swtest (name) VALUES ('Thingy2')  \nDELETE FROM swtest WHERE id = SCOPE_IDENTITY()  \nINSERT INTO swtest (name) VALUES ('Thingy2')  \nDELETE FROM swtest WHERE id = SCOPE_IDENTITY()  \nINSERT INTO swtest (name) VALUES ('Thingy2')  \n\nSELECT * FROM swtest  \nDROP TABLE swtest  