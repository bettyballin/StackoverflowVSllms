SELECT \n  P.PRPT_Id, \n  P.PRPT_Name, \n  COALESCE(PI.ImageCount, 0) AS ImageCount,\n  COALESCE(PI.FirstImageName, '') AS FirstImageName\nFROM \n  Property P\n  LEFT JOIN (\n    SELECT \n      PRPT_Id, \n      COUNT(PIMG_Id) AS ImageCount,\n      MIN(PIMG_ImageName) AS FirstImageName\n    FROM \n      PropertyImages\n    WHERE \n      PIMG_Status = 1\n    GROUP BY \n      PRPT_Id\n  ) PI ON P.PRPT_Id = PI.PRPT_Id\nWHERE \n  P.PRPT_Status = 1;