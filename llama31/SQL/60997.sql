SELECT SSLOTMAK, SSLOTMDL, SSLOTYER, \n       CAST(sum(SSCOUNT) AS DECIMAL(10, 0)) AS COUNT_FIELD\nFROM prqhdrss\nGROUP BY SSLOTMAK, SSLOTMDL, SSLotyer\nHAVING sum(SSCOUNT) > 4\nORDER BY SSLOTMAK, SSLOTMDL, SSLOTYER