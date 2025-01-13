IEnumerable<Team> drew = fixtures\n    .Where(fixture => fixture.Played && fixture.HomeScore == fixture.AwayScore)\n    .SelectMany(fixture => new[] { fixture.HomeTeam, fixture.AwayTeam });