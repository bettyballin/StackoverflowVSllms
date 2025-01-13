Private strategies As New Dictionary(Of PricingStrategy, PricingModel) From\n{\n    {PricingStrategy.STRATEGY_X, New PricingModel(AddressOf PricingModelStrategyX)},\n    {PricingStrategy.STRATEGY_Y, New PricingModel(AddressOf PricingModelStrategyY)}\n}\n\nPublic Sub SwitchStrategy(strategy As PricingStrategy)\n    If strategies.TryGetValue(strategy, model) Then\n        myPricingModel = model\n    End If\nEnd Sub