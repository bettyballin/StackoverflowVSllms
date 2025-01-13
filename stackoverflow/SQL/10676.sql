select id, name\nfrom item_types\nwhere id not in\n    (select i.item_type_id\n    from items i\n    inner join entities e\n        on e.id = t.entity_id\n    where e.Name = 'Bob')