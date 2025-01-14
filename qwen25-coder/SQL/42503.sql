select type, craft, sum(NVL(regular, 0) + NVL(overtime, 0)) as total_hours\nfrom hours_t\ngroup by type, craft\norder by type, craft;