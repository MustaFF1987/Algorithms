package Algorithms_lesson5;


import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

public class CustomTree {

    private Node root;

    private class Node {

        String key;
        Integer value;
        int data;

        public Node(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        Node left;
        Node right;

    }

    public Integer find(String key) {
        Node tmp = root;

        while (tmp != null) {
            int result = key.compareTo(tmp.key);
            if (result == 0) return tmp.value;
            if (result < 0) tmp = tmp.left;
            if (result > 0) tmp = tmp.right;
        }
        return null;
    }

    public void put(String key, Integer value){
        root = put(root, key, value);
    }

    private Node put(Node node, String key, Integer value){
        if (node == null) return new Node(key, value);
        if (key.compareTo(node.key) == 0) node.value = value;
        if (key.compareTo(node.key) < 0) node.left = put(node.left, key, value);
        if (key.compareTo(node.key) > 0) node.right = put(node.right, key, value);
        return node;
    }

/*bЭтот код реализует метод breadthFirstSearch(),
который выполняет обход дерева по уровням, используя очередь.
На каждой итерации извлекается узел из очереди, выводится его значение,
а затем добавляются его левый и правый дочерние узлы в очередь (если они существуют).
Обход продолжается до тех пор, пока очередь не станет пустой.*/

    public void breadthFirstSearch() {
        if (root == null) {
            System.out.println("Дерево пустое");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.key + " ");

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }

    }

    public String getMin(){
        Node tmp = root;

        while (tmp.left != null) {
            tmp = tmp.left;
        }
        return tmp.key;
    }


    // метод для обхода дерева в глубину (DFS)
    public void depthFirstSearch() {
        depthFirstSearchHelper(root);
    }

    // вспомогательный метод для рекурсивного обхода дерева
    private void depthFirstSearchHelper(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.key + " "); // предполагаем, что выводим значение узла

        depthFirstSearchHelper(node.left); // рекурсивно обходим левое поддерево
        depthFirstSearchHelper(node.right); // рекурсивно обходим правое поддерево
    }


    public Iterable<String> keys(){
        Queue<String> queue = new LinkedList<>();
        inorder(root, queue);
        return queue;
    }

    private void inorder(Node tmp, Queue<String> queue) {
        if (tmp == null) return;
        inorder(tmp.left, queue);
        queue.add(tmp.key);
        inorder(tmp.right, queue);
    }


    public static void main(String[] args) {

        CustomTree tree = new CustomTree();
        tree.put("Ivan", 26);
        tree.put("Mary", 33);
        tree.put("Peter", 11);

//        System.out.println(tree.find("Ivan"));
//        System.out.println(tree.find("Mary"));
//        System.out.println(tree.find("Peter"));
//        System.out.println(tree.find("Tom"));

        tree.put("Peter", 50);
//        System.out.println(tree.find("Peter"));

//      System.out.println(tree.getMin());

        System.out.println("Обход дерева по уровням:");
        tree.breadthFirstSearch();

        System.out.println("Обход дерева в глубину:");
        tree.depthFirstSearch();


    }

}