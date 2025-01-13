var hht = from x in db.HandheldAssets\n          join a in db.HandheldDevInfos on x.AssetID equals a.DevName into DevInfo\n          from aa in DevInfo.DefaultIfEmpty()\n          select new\n          {\n              AssetID = x.AssetID,\n              Status = xx.Online.GetValueOrDefault(false)\n          };