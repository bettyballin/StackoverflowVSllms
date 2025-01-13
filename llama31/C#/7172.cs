public List<Ad> SelectAds(List<Ad> ads, int maxAds)\n{\n    var sortedAds = ads.OrderByDescending(a => CalculateEcpm(a.DailyBudget, a.Impressions)).ToList();\n    var selectedAds = new List<Ad>();\n    var totalImpressions = 0;\n\n    foreach (var ad in sortedAds)\n    {\n        var impressions = Math.Min(ad.Impressions, (int)(ad.DailyBudget / ad.Ecpm));\n        totalImpressions += impressions;\n\n        if (totalImpressions >= maxAds)\n        {\n            break;\n        }\n\n        selectedAds.Add(ad);\n    }\n\n    return selectedAds;\n}