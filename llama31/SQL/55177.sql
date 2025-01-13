SELECT \n    ps.name AS PartitionSchemeName,\n    pf.name AS PartitionFunctionName,\n    prv.value AS RangeValue\nFROM \n    sys.partition_schemes ps\nINNER JOIN \n    sys.partition_functions pf ON ps.function_id = pf.function_id\nINNER JOIN \n    sys.partition_range_values prv ON pf.function_id = prv.function_id\nWHERE \n    ps.name = 'YourPartitionSchemeName'\nORDER BY \n    prv.boundary_id;