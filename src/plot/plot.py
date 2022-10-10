

"""
Author: Janelle Einsley S. Agero
Last edited: 10/7/22, 10:40AM
"""
import pandas as pd
import matplotlib. pyplot as plt

"""readFile
reads the file, collects its data, and creates an axis
@param file         - name of the file
@param inputSize    - a holder for the input_size data
@param aveRuntime   - a holder for the ave_runtime data 
@param color        - the color of the line graph
@param label        - the label for the line graph
"""
def readFile (file, inputSize, aveRuntime, color, label):
    dateFile = pd.read_csv(file, delimiter = ',')
    inputSize = dateFile['input_size']
    aveRuntime = dateFile['ave_runtime']
    axes.plot(inputSize, aveRuntime, color, lw = 2, marker = 'o', 
              markerfacecolor = 'black', label = label)

"""configurePlot
creates labels, configues units, and applies legends
@param axes         - the axes that contain plotting information
"""
def configurePlot (axes):
    axes.set_xlabel('Input Size')
    axes.set_ylabel('Average Running Time')
    axes.set_title('Average Running Time per Input Size')
    axes.set_xscale('log', base = 2)
    axes.set_yscale('log', base = 2)
    plt.legend(loc = "upper left")
    
csvFilenames = ["dat/SelectionSortAverageRuntime_50Samples.csv", 
                "dat/QuickSortAverageRuntime_50Samples.csv"]

fig = plt.figure()
axes = fig.add_axes([1.0,1.0,1.6,1.6])


inputSize, aveRuntime = [1,0]

readFile(csvFilenames[0], inputSize, 
         aveRuntime, 'r', "Selection Sort")
readFile(csvFilenames[1], inputSize, 
         aveRuntime, 'b', "Quicksort")

configurePlot(axes)
axes.grid()
axes.minorticks_on()

plt.savefig("dat/output.png", dpi = 100, bbox_inches = 'tight')
