try:\n    from skynet import SkyNet\n    class SelfAwareSkyNet(SkyNet):\n        pass\nexcept ImportError:\n    class SelfAwareSkyNet:\n        pass