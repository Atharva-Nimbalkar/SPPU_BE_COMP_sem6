def printConfiguration(colorArray, colorNames):
    print("The assigned colors are as follows:")
    for i in range(1, len(colorArray) + 1):
        color_name = colorNames[colorArray[i - 1] - 1]
        print("Vertex:", i, "Color:", color_name)

def isSafe(v, colorArray, vertex):
    for i in range(len(graph)):
        if graph[v][i] == 1 and colorArray[i] == vertex:
            return False
    return True


def graphColoringAlgorithmUtil(m, colorArray, currentVertex):
    # base case.
    if currentVertex == len(graph):
        return True

    for i in range(1, m + 1):
        if isSafe(currentVertex, colorArray, i) == True:
            colorArray[currentVertex] = i
            if graphColoringAlgorithmUtil(m, colorArray, currentVertex + 1):
                return True
            # backtrack
            colorArray[currentVertex] = 0


def graphColoringAlgorithm(graph, m):
    V = len(graph)
    # Initially the color array is initialized with 0.
    colorArray = [0] * V

    # Call graphColoringAlgorithmUtil() for vertex 0.
    if not graphColoringAlgorithmUtil(m, colorArray, 0):
        print("Coloring is not possible!")
        return False

    # Print the solution
    print("Coloring is possible!")
    # Define color names corresponding to color numbers
    colorNames = ["red", "blue", "green", "yellow", "orange", "purple", "pink", "brown", "cyan", "magenta"]
    printConfiguration(colorArray, colorNames)
    return True


if __name__ == '__main__':

    V = int(input("Enter the number of vertices: "))
    graph = []
    print("Enter the adjacency matrix of the graph:")
    for _ in range(V):
        row = list(map(int, input().split()))
        graph.append(row)
    m = int(input("Enter the number of colors: "))

    graphColoringAlgorithm(graph, m)
