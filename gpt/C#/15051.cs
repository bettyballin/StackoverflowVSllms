string domainPattern = @"^(?!-)[A-Za-z0-9-]{1,63}(?<!-)(\.[A-Za-z0-9-]{1,63})*\.[A-Za-z]{2,6}$";\nRegex domainRegex = new Regex(domainPattern);