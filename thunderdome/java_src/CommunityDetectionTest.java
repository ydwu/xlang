import generated.scala.communitydetectionp.Tup2DeliteArrayIntDeliteArrayInt;
import xlang.java.Graph;

public class CommunityDetectionTest {
  public static void main(String[] args) {
    int[] nodes = {0, 2, 4, 6};
    int[] edges = {1, 2, 0, 2, 0, 1};
    Tup2DeliteArrayIntDeliteArrayInt result = communityDetection(nodes, edges);

    // do equivalent with a graph object...
    testCD();
  }

  public static Graph testCD() {
    int[] nodes = {0, 2, 4, 6};
    int[] edges = {1, 2, 0, 2, 0, 1};
    Graph graph = new Graph(nodes, edges);
    Graph outGraph = communityDetection(graph);
    return outGraph;
  }

  /**
   * Assumes a set value for k, since we don't yet have an invokeGraph method that takes a graph and an argument
   * @param graph
   * @return
   */
  public static Graph communityDetection(Graph graph) {
    System.out.println("communityDetection.in " + graph);

    double k = 0.01;

    Tup2DeliteArrayIntDeliteArrayInt result = CommunityDetection.apply(graph.getRowIndex(), graph.getColIndex(), k);

    int[] resultNodes = result._1();
    int[] resultEdges = result._2();

    for (Integer n : resultNodes) System.out.println("communityDetection.node " + n);
    for (Integer n : resultEdges) System.out.println("communityDetection.edge " + n);

    Graph graph1 = new Graph(resultNodes, resultEdges);

    System.out.println("communityDetection.out "+ graph1);
    return graph1;

  }

  private static Tup2DeliteArrayIntDeliteArrayInt communityDetection(int[] nodes, int[] edges) {
    double k = 0.01;

    return CommunityDetection.apply(nodes, edges, k);
  }
}
