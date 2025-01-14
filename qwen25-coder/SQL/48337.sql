SELECT S.VISITORIP, S.HTTPADDRESS, S.DATEENTERED\nFROM STATS S\nJOIN (\n    SELECT VISITORIP, MAX(DATEENTERED) AS MaxDateEntered \n    FROM STATS \n    WHERE DATEENTERED BETWEEN '" & OnlineTime & "' AND '" & NOW() & "' \n    GROUP BY VISITORIP\n) S1 ON S.VISITORIP = S1.VISITORIP AND S.DATEENTERED = S1.MaxDateEntered\nWHERE S.DATEENTERED BETWEEN '" & TIME & "' AND '" & NOW() & "'\nGROUP BY S.VISITORIP, S.HTTPADDRESS, S.DATEENTERED\nORDER BY S.DATEENTERED DESC;