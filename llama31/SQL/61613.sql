CREATE TRIGGER UPDATE_PRODUCT_RATING\nAFTER INSERT OR UPDATE OF RATING ON REVIEW\nREFERENCING NEW AS N\nFOR EACH ROW\nBEGIN\n    UPDATE PRODUCT\n    SET RATING = (SELECT AVG(RATING) FROM REVIEW WHERE PRODUCTNAME = N.PRODUCTNAME)\n    WHERE PRODUCTNAME = N.PRODUCTNAME;\nEND;