
import networkx as nx
import matplotlib.pyplot as plt

# Must do pip3 install networkx and pip3 install matplotlib

def create_graph(input_list):

    G = nx.DiGraph()
    n = len(input_list)

    # Add vertices and edges to the graph
    for i, (vertex, number) in enumerate(input_list):
        # Calculate the indices of the adjacent vertices considering the circular nature
        left_index = (i - number) % n
        right_index = (i + number) % n

        # Add edges to the graph
        G.add_edge(vertex, input_list[left_index][0])
        G.add_edge(vertex, input_list[right_index][0])

    return G



def draw_graph(G):
    # Draw the graph
    pos = nx.circular_layout(G)
    nx.draw(G, pos, with_labels=True, node_size=2000, node_color='orange', font_size=20, font_weight='bold', arrowsize=20)

    # Show the image
    plt.title("Directed Graph")
    plt.show()

if __name__ == "__main__":
    input_str = input_list = [('I', 2), ('A', 5), ('E', 4), ('F', 1), ('T', 2), ('S', 3)]
    # input_str = input("Enter the sequence of vertices-number pairs: ")
    if input_str:
        graph = create_graph(input_str)
        draw_graph(graph)
    else:
        print("Input is empty.")
