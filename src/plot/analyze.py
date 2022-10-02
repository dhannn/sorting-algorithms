

"""
Jnl moment
"""
import pandas as pd
import matplotlib. pyplot as plt

#gets the file
dataFile = pd.read_csv('TestSortRuntime_100Samples.csv', delimiter = ',')
#assigning a column to the variables
input_size = dataFile['input_size']
ave_running_time = dataFile ['ave_running_time']

fig = plt.figure()
axes = fig.add_axes([0.1, 0.1,1.6,1.6])

axes.plot(input_size, ave_running_time, 'r', lw = 2, marker = 'o', markerfacecolor = 'black')
axes.set_xlabel('Input Size')
axes.set_ylabel('Average Running Time')
axes.set_title('Average Running Time per Input Size')

axes.set_xscale('log', base = 2)
axes.set_yscale('log', base = 2)

plt.show()

