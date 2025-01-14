class Rectangle:\n    def __init__(self, x1, y1, x2, y2):\n        self.x1 = x1\n        self.y1 = y1\n        self.x2 = x2\n        self.y2 = y2\n\ndef route_edge(start_point, end_point, start_bounds, end_bounds):\n    # Calculate midpoints of the rectangles for simplicity\n    mid_x1 = (start_bounds.x1 + start_bounds.x2) / 2\n    mid_y1 = (start_bounds.y1 + start_bounds.y2) / 2\n\n    mid_x2 = (end_bounds.x1 + end_bounds.x2) / 2\n    mid_y2 = (end_bounds.y1 + end_bounds.y2) / 2\n\n    # Determine the direction of routing based on positions\n    if abs(start_point[0] - end_point[0]) > abs(start_point[1] - end_point[1]):\n        # Route horizontally then vertically\n        route = [\n            (start_point, (mid_x2, start_point[1])),\n            ((mid_x2, start_point[1]), (mid_x2, mid_y2)),\n            ((mid_x2, mid_y2), end_point)\n        ]\n    else:\n        # Route vertically then horizontally\n        route = [\n            (start_point, (start_point[0], mid_y2)),\n            ((start_point[0], mid_y2), (mid_x2, mid_y2)),\n            ((mid_x2, mid_y2), end_point)\n        ]\n\n    return route\n\n# Example usage:\nstart_bounds = Rectangle(0, 0, 10, 10)\nend_bounds = Rectangle(50, 50, 60, 60)\n\nstart_point = (5, 5)  # Anchor point on start_bounds\nend_point = (55, 55)    # Anchor point on end_bounds\n\nroute = route_edge(start_point, end_point, start_bounds, end_bounds)\nprint("Routing points:", route)