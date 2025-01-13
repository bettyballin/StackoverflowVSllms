var relatedVideos = (from v1 in videos\n                     from v2 in videos\n                     where v1.VideoID == 1 && v1.VideoID != v2.VideoID\n                     let v1Tags = v1.Tags.Split(',').Select(tag => tag.Trim())\n                     let v2Tags = v2.Tags.Split(',').Select(tag => tag.Trim())\n                     let matchCount = v1Tags.Intersect(v2Tags).Count()\n                     orderby matchCount descending\n                     select new { v2.VideoID, v2.Title, MatchCount = matchCount }).ToList();