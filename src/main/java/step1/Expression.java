package step1;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private final List<Node> nodeList;
    private final List<Operator> operatorList;

    public Expression(List<Node> nodeList, List<Operator> operatorList) {
        this.nodeList = nodeList;
        this.operatorList = operatorList;
    }

    public static List<Node> extractNodes(List<String> inputList) {
        List<Node> nodeList = new ArrayList<>();
        for (String inputString : inputList) {
            extractNode(nodeList, inputString);
        }
        return nodeList;
    }

    private static void extractNode(List<Node> nodeList, String token) {
        if(Node.isNode(token)) {
            nodeList.add(new Node(token));
        }
    }

    public static List<Operator> extractOperators(List<String> inputList) {
        List<Operator> operatorList = new ArrayList<>();
        for (String inputString : inputList) {
            extractOperator(operatorList, inputString);
        }
        return operatorList;
    }

    private static void extractOperator(List<Operator> operatorList, String token) {
        if (Operator.isOperator(token)) {
            operatorList.add(new Operator(token));
        }
    }

    public int execute() {
        int sum = nodeList.get(0).getValue();
        for (int i = 0; i < operatorList.size(); i++) {
            sum = operatorList.get(i).calculate(sum, nodeList.get(i + 1).getValue());
        }
        return sum;
    }
}
