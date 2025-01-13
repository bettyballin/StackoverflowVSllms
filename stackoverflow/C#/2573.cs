private GridLength myHorizontalInputRegionSize = new GridLength(0, GridUnitType.Auto)\npublic GridLength HorizontalInputRegionSize\n{\n    get\n    {\n        // If not yet set, get the starting value from the DataModel\n        if (myHorizontalInputRegionSize.IsAuto)\n            myHorizontalInputRegionSize = new GridLength(ConnectionTabDefaultUIOptions.HorizontalInputRegionSize, GridUnitType.Pixel);\n        return myHorizontalInputRegionSize;\n    }\n    set\n    {\n        myHorizontalInputRegionSize = value;\n        if (ConnectionTabDefaultUIOptions.HorizontalInputRegionSize != myHorizontalInputRegionSize.Value)\n        {\n            // Set the value in the DataModel\n            ConnectionTabDefaultUIOptions.HorizontalInputRegionSize = value.Value;\n        }\n        OnPropertyChanged("HorizontalInputRegionSize");\n    }\n}