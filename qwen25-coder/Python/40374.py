def run_with_transaction(func, *args, **kw):\n    pass\n\n# Manually applying the decorator using assignment\nrun_with_transaction = dispatch.generic(MultiorderGenericFunction)(run_with_transaction)