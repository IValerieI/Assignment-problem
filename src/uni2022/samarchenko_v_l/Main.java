package uni2022.samarchenko_v_l;

public class Main {

    public static void main(String[] args) {
        test1();

    }

    public static void test1() {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1, 1, 0);
        graph.addEdge(0, 2, 1, 0);

        graph.addEdge(1, 3, 1, 1);
        graph.addEdge(1, 4, 1, 2);

        graph.addEdge(2, 3, 1, 3);
        graph.addEdge(2, 4, 1, 4);

        graph.addEdge(3, 5, 1, 0);
        graph.addEdge(4, 5, 1, 0);

        Flow flow = new Flow();
        int[] res = flow.findMinCostMaxFlow(graph, 0, 5, Integer.MAX_VALUE);
        int flowValue = res[0];
        int flowCost = res[1];

        System.out.println("flowValue - " + flowValue);
        System.out.println("flowCost - " + flowCost);


    }

    public static void test2() {
        Graph graph = new Graph(3);
        graph.addEdge(0, 1, 3, 1);
        graph.addEdge(0, 2, 2, 1);
        graph.addEdge(1, 2, 2, 1);

        Flow flow = new Flow();
        int[] res = flow.findMinCostMaxFlow(graph, 0, 2, Integer.MAX_VALUE);
        int flowValue = res[0];
        int flowCost = res[1];

        System.out.println("flowValue - " + flowValue);
        System.out.println("flowCost - " + flowCost);
    }

}













//    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////
////        int n = scanner.nextInt();
//        GraphArr graphArr = new GraphArr(6);
//        graphArr.addEdge(0, 1);
//        graphArr.addEdge(0, 2);
//
//        graphArr.addEdge(1, 3);
//        graphArr.addEdge(1, 4);
//        graphArr.addEdge(2, 3);
//        graphArr.addEdge(2, 4);
//
//        graphArr.addEdge(3, 5);
//        graphArr.addEdge(4, 5);
//
//        graphArr.print();
//
//    }