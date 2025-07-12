public class SearchDataStructures {
    public static boolean arraySearch(int[] arr, int target) {
        for (int val : arr)
            if (val == target) return true;
        return false;
    }
    static class SimpleHashSet {
        private int[] table;
        private boolean[] occupied;
        private int size;

        public SimpleHashSet(int capacity) {
            table = new int[capacity];
            occupied = new boolean[capacity];
            size = capacity;
        }

        private int hash(int key) {
            return Math.abs(key) % size;
        }

        public void add(int key) {
            int idx = hash(key);
            while (occupied[idx]) {
                if (table[idx] == key) return;
                idx = (idx + 1) % size;
            }
            table[idx] = key;
            occupied[idx] = true;
        }

        public boolean contains(int key) {
            int idx = hash(key);
            while (occupied[idx]) {
                if (table[idx] == key) return true;
                idx = (idx + 1) % size;
            }
            return false;
        }
    }
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static class SimpleTreeSet {
        private TreeNode root;

        public void add(int val) {
            root = insert(root, val);
        }

        private TreeNode insert(TreeNode node, int val) {
            if (node == null) return new TreeNode(val);
            if (val < node.val) node.left = insert(node.left, val);
            else if (val > node.val) node.right = insert(node.right, val);
            return node;
        }

        public boolean contains(int val) {
            return search(root, val);
        }

        private boolean search(TreeNode node, int val) {
            if (node == null) return false;
            if (node.val == val) return true;
            else if (val < node.val) return search(node.left, val);
            else return search(node.right, val);
        }
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 100000};
        int target = -1;

        for (int size : sizes) {
            int[] arr = new int[size];
            SimpleHashSet hashSet = new SimpleHashSet(size * 2);
            SimpleTreeSet treeSet = new SimpleTreeSet();

            for (int i = 0; i < size; i++) {
                arr[i] = (int)(Math.random() * size * 10);
                hashSet.add(arr[i]);
                treeSet.add(arr[i]);
            }

            long start = System.nanoTime();
            arraySearch(arr, target);
            long arrayTime = System.nanoTime() - start;

            start = System.nanoTime();
            hashSet.contains(target);
            long hashTime = System.nanoTime() - start;

            start = System.nanoTime();
            treeSet.contains(target);
            long treeTime = System.nanoTime() - start;

            System.out.printf("N=%d | Array: %d ms | HashSet: %d ms | TreeSet: %d ms\n",
                    size, arrayTime / 1_000_000, hashTime / 1_000_000, treeTime / 1_000_000);
        }
    }
}
