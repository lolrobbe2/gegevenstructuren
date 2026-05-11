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
        boolean result = left.build(localQuestions, animalsYes, localAnswers);
        boolean result2 = right.build(localQuestions, animalsNo, localAnswers);
        return  result && result2;
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
        if(left.isLeafNode() && right.isLeafNode()) {
            return (right.value != null ? right.value : left.value) + "\n";
        } else {
            String result = indent + value + "\n";
            if (left != null && right != null) {
                result += indent + "--N--> ";
                result += left.toString(indent + "\t");
                result += indent + "--Y--> ";
                result += right.toString(indent + "\t");
                return result;
            }
        }
        return "";
    }
    boolean isLeafNode(){
        return left == null || right == null;
    }
}
