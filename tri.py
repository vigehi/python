import numpy as np
import pandas as pd
df = pd.DataFrame({
   "date": pd.date_range(start="2020-05-01", periods=100, freq="D"),
   "temperature": np.random.randint(18, 30, size=100) +  
                  np.random.random(100).round(1)
})