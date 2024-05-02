def is_safe(graph, color,v,V,c):
 for i in range(V):
    if graph[v][i] and c == color[i]:
        return False
 return True
def graph_coloring_util(graph, color, v, V, m):
    if v == V:
        return True

    for c in range(m):
        if is_safe( graph, color, v,V,colors[c]):
            color[v] = colors[c]
            if graph_coloring_util(graph, color, v + 1, V, m):
                return True
            color[v] = None
    return False
def graph_coloring(graph,  vertices,m, colors):
 V = len(graph)
 color = [None] * V

 if not graph_coloring_util(graph, color, 0, V, m):
    print("Solution does not exist.")
    return
 print("Solution exists. The coloring of vertices is:")
 for i in range(V):
     print(f"Vertex {vertices[i]} ---> Color {color[i]}")
 # Displaying the graph
 print("Graph:")
 for i in range(V):
    for j in range(V):
        print(graph[i][j], end=" ")
    print()

if __name__ == "__main__":
 num_vertices = int(input("Enter the number of vertices: "))
 vertices = [input(f"Enter vertex {i+1}: ") for i in range(num_vertices)]
 print("Enter the adjacency matrix (0/1):")
 graph = []
 for _ in range(num_vertices):
    row = list(map(int, input().split()))
    graph.append(row)


 m = int(input("Enter the number of colors available: "))
 colors = []
 for i in range(m):
    color = input(f"Enter color {i+1} name: ")
    colors.append(color)
 graph_coloring(graph, vertices,m, colors)