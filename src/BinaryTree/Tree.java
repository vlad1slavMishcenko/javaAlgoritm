package BinaryTree;

public class Tree {

        private Node root;


        public boolean add(int value){
            if (root != null){
                boolean result = addNode(root, value);
                root = rebalance(root);
                root.color = Color.BLACK;
                return result;
            }else {
                root = new Node();
                root.color = Color.BLACK;
                root.value = value;
                return  true;
            }
        }
        private boolean addNode(Node node, int value){
            if (node.value == value){
                return false;
            }else {
                if (node.value > value){
                    if (node.leftChild != null){
                        boolean result = addNode(node.leftChild, value);
                        node.leftChild = rebalance(node.leftChild);
                        return result;
                    } else {
                        node.leftChild = new Node();
                        node.leftChild.color = Color.RED;
                        node.leftChild.value =value;
                        return true;
                    }
                }else {
                    if (node.rightChild != null){
                        boolean result = addNode(node.rightChild, value);
                        node.rightChild = rebalance(node.rightChild);
                        return result;
                    }else {
                        node.rightChild = new Node();
                        node.rightChild.color = Color.RED;
                        node.rightChild.value = value;
                        return true;
                    }
                }
            }
        }


        private Node rebalance(Node node){
            Node result = node;
            boolean needREbalance;
            do{
                needREbalance = false;
                if (result.rightChild != null && result.rightChild.color == Color.RED &&
                        (result.leftChild == null || result.leftChild.color == Color.BLACK)){
                    needREbalance = true;
                    result = rightSwap(result);
                }
                if (result.leftChild != null && result.leftChild.color == Color.RED &&
                        result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED){
                    needREbalance = true;
                    result = leftSwap(result);
                }
                if (result.leftChild != null && result.leftChild.color == Color.RED &&
                        result.rightChild != null && result.rightChild.color == Color.RED){
                    needREbalance = true;
                    swapColor(result);
                }
            }
            while (needREbalance);
            return result;
        }
        private void swapColor(Node node){
            node.rightChild.color = Color.BLACK;
            node.leftChild.color = Color.BLACK;
            node.color = Color.RED;
        }

        private Node rightSwap(Node node){
            Node rightChild = node.rightChild;
            Node between = rightChild.leftChild;
            rightChild.leftChild = node;
            node.rightChild = between;
            rightChild.color = node.color;
            node.color = Color.RED;
            return rightChild;
        }
        private Node leftSwap(Node node){
            Node leftChild = node.leftChild;
            Node between = leftChild.rightChild;
            leftChild.rightChild = node;
            node.leftChild = between;
            leftChild.color = node.color;
            node.color = Color.RED;
            return leftChild;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "root=" + root.value + " " + root.color+
                    '}';
        }




        public class Node{
            public int value;
            public Color color;
            public Node leftChild;
            public Node rightChild;

        }

        private enum Color{
            RED, BLACK
        }

}
