IEnumerable<Team> drew = (from fixture in fixtures\n                     where fixture.Played \n                        && (fixture.HomeScore == fixture.AwayScore)\n                     select fixture.HomeTeam)\n                     .Union(from fixture in fixtures\n                     where fixture.Played \n                        && (fixture.HomeScore == fixture.AwayScore)\n                     select fixture.AwayTeam);