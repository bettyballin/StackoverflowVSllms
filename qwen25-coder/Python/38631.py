from ortools.packing import binpacking_pb2\nfrom ortools.packing import packing_solver\n\ndef main():\n    # Define box dimensions (width, height, depth)\n    large_box = [50, 40, 30]\n    items = [\n        (10, 6, 5), (8, 7, 3), (9, 2, 4),\n        (11, 5, 7), (6, 8, 5)\n    ]\n\n    # Create the model.\n    bin_pack_params = packing_solver.DefaultPackingParameters()\n    solver = packing_solver.Solver(False)\n\n    bins = bin_pack_params.bin()\n    bins.add_box(large_box[0], large_box[1], large_box[2])\n\n    for item_id, (width, height, depth) in enumerate(items):\n        box = bins.box(0).add_item().add_box(width, height, depth)\n        box.set_id(item_id)\n\n    # Solve the problem.\n    ok, packing_result = solver.SolveWithParameters(bin_pack_params)\n    if not ok:\n        print('No solution found.')\n        return\n\n    print(f'Using {binning_solution.num_bins()} bin(s).')\n    for i in range(packing_result.bins_size()):\n        bin = packing_result.bins(i)\n        volume = 0\n        rect_count = len(bin.items()[1].rects())\n        weight = 0.0 if bin.items().has_weight() else -1.0\n\n        print(f'\nBin {i}:')\n        for j in range(rect_count):\n            box = bin.items().boxes(j)\n            volume += box.width() * box.height() * box.depth()\n            weight += 1.0 if bin.items().has_weight() else 0.0\n            print(\n                f'Box ({box.x_low()}, {box.y_low()}, {box.z_low()}), '\n                f'dimensions: [{box.width()}, {box.height()}, {box.depth()}]'\n            )\n        print(f'Total volume: {volume}')\n    return\n\nif __name__ == '__main__':\n    main()