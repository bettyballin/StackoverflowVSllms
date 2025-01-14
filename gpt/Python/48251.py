from itertools import combinations\n\ndef unique_permutations(n, m, e1, e2):\n    elements = [e1] * n + [e2] * m\n    unique_perms = set()\n\n    def is_circular_unique(perm):\n        length = len(perm)\n        for i in range(1, length):\n            if perm[i:] + perm[:i] in unique_perms:\n                return False\n        return True\n\n    def is_mirror_unique(perm):\n        return tuple(reversed(perm)) not in unique_perms\n\n    def generate_permutations(elements):\n        if not elements:\n            return [[]]\n        current = elements[0]\n        rest_perms = generate_permutations(elements[1:])\n        result = []\n        for perm in rest_perms:\n            for i in range(len(perm) + 1):\n                result.append(perm[:i] + [current] + perm[i:])\n        return result\n\n    for perm in generate_permutations(elements):\n        tupled_perm = tuple(perm)\n        if tupled_perm not in unique_perms and is_circular_unique(tupled_perm) and is_mirror_unique(tupled_perm):\n            unique_perms.add(tupled_perm)\n\n    return unique_perms\n\n# Example usage\nn = 2\nm = 2\ne1 = 'a'\ne2 = 'b'\nunique_perms = unique_permutations(n, m, e1, e2)\nfor perm in unique_perms:\n    print(perm)