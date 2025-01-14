import pkg_resources\n\n    class AddonManager:\n        def __init__(self):\n            self.addons = []\n        \n        def load_addons(self):\n            for ep in pkg_resources.iter_entry_points('myframework.addons'):\n                addon_class = ep.load()\n                addon_instance = addon_class(self)\n                addon_instance.activate()\n                self.addons.append(addon_instance)\n    \n    # Usage\n    if __name__ == "__main__":\n        manager = AddonManager()\n        manager.load_addons()\n        print(f"Loaded {len(manager.addons)} addons.")