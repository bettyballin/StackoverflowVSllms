Order By \n    Case When Left(name, 2) = 'KL' \n        Then 'KL' + Replace(Str(Cast(replace(name, 'KL', '') as BigInt), 12), ' ', '0')\n        Else name End