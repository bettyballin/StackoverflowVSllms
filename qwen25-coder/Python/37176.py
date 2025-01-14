def make_teams(que):\n    que.sort(reverse=True)  # Sort in descending order to try larger numbers first\n    t1, t2 = [], []\n\n    for number in que:\n        # Add the number to the team with the smaller current sum\n        if sum(t1) < sum(t2):\n            t1.append(number)\n        else:\n            t2.append(number)\n\n    print(min(sum(t1), sum(t2)), max(sum(t1), sum(t2)))\n\n# Example usage\nque = [2, 3, 10, 5, 8, 9, 7, 3, 5, 2]\nmake_teams(que)