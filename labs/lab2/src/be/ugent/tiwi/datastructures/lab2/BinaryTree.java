package be.ugent.tiwi.datastructures.lab2;

import java.util.List;
import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sleroux
 */
public class BinaryTree {

    private BinaryTree left; //yes
    private BinaryTree right; //no
    private String value;

    public boolean build(List<String> questions, List<String> animals, List<Map<String, Boolean>> answers) {
        List<String> localQuestions = new ArrayList<>(questions);
        List<String> localAnimals = new ArrayList<>(animals);
        List<Map<String, Boolean>> localAnswers = new ArrayList<>(answers);

        if (questions.isEmpty()) {
            if (localAnimals.size() == 1) {
                this.value = localAnimals.getFirst();
                return true;
            }
            return false;
        }
        this.value = questions.getFirst();
        Map<String, Boolean> currentAnswers = localAnswers.getFirst();
        localAnswers.removeFirst();
        localQuestions.removeFirst();

        List<String> animalsYes = new ArrayList<>();
        List<String> animalsNo = new ArrayList<>();

        for (String animal : localAnimals) {
            if (currentAnswers.get(animal) == true) {
                animalsYes.add(animal);
            } else {
                animalsNo.add(animal);
            }
        }
        left = new BinaryTree();
        right = new BinaryTree();
        boolean leftResult = left.build(localQuestions, animalsYes, localAnswers);
        boolean rightResult = right.build(localQuestions, animalsNo, localAnswers);
        if (!rightResult) {
            right = null;
        }
        if (!leftResult) {
            left = null;
        }
        return leftResult || rightResult;
    }

    public int height() {
        return 0;
    }

    public double averageDepth() {
        return 0;
    }

    @Override
    public String toString() {
        return toString("");
    }

    private String toString(String indent) {

        String result = value + "\n";
        if (left != null && right != null) {
            String leftValue = left.toString(indent + "\t");
            String rightValue = right.toString(indent + "\t");
            if (leftValue.isEmpty() && rightValue.isEmpty())
                return "";
            if (!leftValue.isEmpty()) {
                result += indent + "--N--> ";
                result += leftValue;
            }
            if (!rightValue.isEmpty()) {
                result += indent + "--Y--> ";
                result += rightValue;
            }
            return result;
        } else if (left != null) {
            String leftValue = left.toString(indent + "\t");
            if (!leftValue.isEmpty()) {
                result += indent + "--N--> ";
                result += leftValue;
                return result;
            }
        } else if (right != null) {
            String rightValue = right.toString(indent + "\t");
            if (!rightValue.isEmpty()) {
                result += indent + "--Y--> ";
                result += rightValue;
                return result;
            }
        }
        return "\t" + value + "\n";
    }

    boolean isLeafNode() {
        return left == null || right == null;
    }

    int getLeafCount() {
        int leafCount = 0;
        if (left == null && right == null) {
            return 1;
        }
        if (left != null) {
            leafCount += left.getLeafCount();
        }
        if (right != null) {
            leafCount += right.getLeafCount();
        }

        return leafCount;
    }
}
