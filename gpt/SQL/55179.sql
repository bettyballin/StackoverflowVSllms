IF ((@TablesToDeleteFrom & 1) <> 0 AND\n    (@TablesToDeleteFrom & 2) <> 0 AND\n    (@TablesToDeleteFrom & 4) <> 0 AND\n    (@TablesToDeleteFrom & 8) <> 0 AND\n    (EXISTS (SELECT UserId FROM dbo.aspnet_Users WHERE @UserId = UserId)))\nBEGIN\n    ...\nEND