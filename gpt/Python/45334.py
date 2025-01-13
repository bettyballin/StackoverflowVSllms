class RadixTreeNode:\n    def __init__(self, key=""):\n        self.key = key\n        self.children = {}\n        self.is_end = False\n\nclass RadixTree:\n    def __init__(self):\n        self.root = RadixTreeNode()\n    \n    def insert(self, word):\n        node = self.root\n        while word:\n            for child_key, child_node in node.children.items():\n                common_prefix = self._common_prefix(word, child_key)\n                if common_prefix:\n                    if common_prefix == child_key:\n                        node = child_node\n                        word = word[len(common_prefix):]\n                        break\n                    else:\n                        new_child = RadixTreeNode(child_key[len(common_prefix):])\n                        new_child.children = child_node.children\n                        new_child.is_end = child_node.is_end\n                        child_node.key = common_prefix\n                        child_node.children = {new_child.key: new_child}\n                        child_node.is_end = False\n                        node.children[child_key] = child_node\n                        node = child_node\n                        word = word[len(common_prefix):]\n                        break\n            else:\n                new_node = RadixTreeNode(word)\n                node.children[word] = new_node\n                new_node.is_end = True\n                break\n    \n    def _common_prefix(self, str1, str2):\n        min_len = min(len(str1), len(str2))\n        for i in range(min_len):\n            if str1[i] != str2[i]:\n                return str1[:i]\n        return str1[:min_len]\n    \n    def search_prefix(self, prefix):\n        node = self.root\n        while prefix:\n            for child_key, child_node in node.children.items():\n                if child_key.startswith(prefix):\n                    return self._collect_words(child_node, prefix)\n                common_prefix = self._common_prefix(prefix, child_key)\n                if common_prefix == child_key:\n                    node = child_node\n                    prefix = prefix[len(common_prefix):]\n                    break\n            else:\n                return []\n        return self._collect_words(node, prefix)\n    \n    def _collect_words(self, node, prefix):\n        result = []\n        stack = [(node, prefix)]\n        while stack:\n            current_node, current_prefix = stack.pop()\n            if current_node.is_end:\n                result.append(current_prefix)\n            for child_key, child_node in current_node.children.items():\n                stack.append((child_node, current_prefix + child_key))\n        return result\n\n# Example usage\nradix_tree = RadixTree()\nwords = ["illness", "imaginary", "imagination", "imagine", "imitation", "immediate", "immediately", "immense", "in"]\nfor word in words:\n    radix_tree.insert(word)\n\nprefix = "im"\nprint(radix_tree.search_prefix(prefix))