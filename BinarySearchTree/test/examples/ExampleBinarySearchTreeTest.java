package examples;

import interfaces.IBinarySearchTreeTest;

public class ExampleBinarySearchTreeTest implements IBinarySearchTreeTest<ExampleBinarySearchTree> {
    @Override
    public ExampleBinarySearchTree createBinarySearchTree() {
        return new ExampleBinarySearchTree();
    }
}
