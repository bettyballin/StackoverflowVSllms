def resolve_order(order, map, units):\n    # validate order (e.g., check if unit exists, destination is valid)\n    # ...\n\n    if order.type == 'move':\n        # check if destination is empty or occupied by a friendly unit\n        # ...\n        # update unit location\n        unit.location = order.destination\n    elif order.type == 'support':\n        # check if supporting unit is in a valid location\n        # ...\n        # mark supported unit as supported\n        supported_unit.supported = True\n    elif order.type == 'convoy':\n        # check if convoying unit is in a valid location\n        # ...\n        # update unit location (if convoy is successful)\n        unit.location = order.destinatio