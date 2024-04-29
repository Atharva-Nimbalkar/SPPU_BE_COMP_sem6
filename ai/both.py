from collections import deque

def bfs(graph, start):
    visited = set()
    queue = deque([start])

    while queue:
        node = queue.popleft()
        if node not in visited:
            print(node, end=' ')
            visited.add(node)
            queue.extend(graph[node])

def dfs(graph, start, visited=None):
    if visited is None:
        visited = set()
    visited.add(start)
    print(start, end=' ')

    for neighbor in graph[start]:
        if neighbor not in visited:
            dfs(graph, neighbor, visited)

def main():
    graph = {}
    num_edges = int(input("Enter the number of edges: "))

    for _ in range(num_edges):
        node, *neighbors = input("Enter node and its adjacent nodes separated by space: ").split()
        graph[node] = neighbors

    choice = input("Enter 'B' for BFS or 'D' for DFS traversal: ")
    if choice.upper() == 'B':
        bfs_start = input("Enter the starting node for BFS traversal: ")
        print("BFS traversal:")
        bfs(graph, bfs_start)
    elif choice.upper() == 'D':
        dfs_start = input("Enter the starting node for DFS traversal: ")
        print("DFS traversal:")
        dfs(graph, dfs_start)
    else:
        print("Invalid choice. Please enter 'B' for BFS or 'D' for DFS.")

if __name__ == "__main__":
    main()
