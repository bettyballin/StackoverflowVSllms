def calculate_box_sizes(viewport_width, num_boxes):\n    """\n    Calculate the width of each box to fill the viewport width,\n    with each box 10% smaller than the one to its left.\n\n    Args:\n        viewport_width (int): The width of the viewport.\n        num_boxes (int): The number of boxes.\n\n    Returns:\n        list: A list of box widths.\n    """\n    box_sizes = []\n    remaining_width = viewport_width\n    for i in range(num_boxes, 0, -1):\n        box_width = remaining_width / (1 + (num_boxes - i) * 0.1)\n        remaining_width -= box_width\n        box_sizes.append(int(box_width))\n    return box_sizes[::-1]