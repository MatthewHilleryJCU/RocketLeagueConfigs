import os
import sys



folder = r'D:\CODE\RocketLeagueConfigs/Test'
for filename in os.listdir(folder):
    infilename = os.path.join(folder, filename)
    if not os.path.isfile(infilename):
        continue
    oldbase = os.path.splitext(filename)
    newname = infilename.replace('.txt', '.ini')
    output = os.rename(infilename, newname)
