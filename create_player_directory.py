import pandas as pd
import os
from pandas import ExcelWriter
from pandas import ExcelFile

df = pd.read_excel(
    'D:\CODE\RocketLeagueConfigs\pro_camera_settings.xlsx', sheet_name='Sheet1')

path = 'D:\CODE\RocketLeagueConfigs\pros'


player_names = df['Player']
for i in player_names:
    os.mkdir(os.path.join(path, i))
