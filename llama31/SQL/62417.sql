SELECT S.VISITORIP, S.HTTPADDRESS, S.DATEENTERED\nFROM STATS S\nJOIN (\n  SELECT S1.VISITORIP, MAX(S1.DATEENTERED) AS MAX_DATEENTERED\n  FROM STATS S1\n  WHERE S1.DATEENTERED BETWEEN '" & OnlineTime & "' AND '" & NOW() & "'\n  GROUP BY S1.VISITORIP\n) S1\nON S.VISITORIP = S1.VISITORIP AND S.DATEENTERED = S1.MAX_DATEENTERED\nWHERE S.DATEENTERED BETWEEN '" & TIME & "' AND '" & NOW() & "'\nORDER BY S.DATEENTERED DESC