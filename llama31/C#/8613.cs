int[] b = ...;\nobject variant = Marshal.GetNativeVariantForObject(b, typeof(int[]));\nGetFoo(variant);