declare @bitHaveRows bit\nselect @bitHaveRows = IIF(count(*) > 0, 1, 0)\nfrom table\nwhere (predicate)