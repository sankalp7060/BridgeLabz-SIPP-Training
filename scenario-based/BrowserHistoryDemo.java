public class BrowserHistoryDemo {
    public static void main(String[] args) {
        System.out.println("===== Browser History Demo =====");

        AppHistory browser = new AppHistory();
        browser.visit("https://google.com");
        browser.visit("https://youtube.com");
        browser.visit("https://github.com");

        System.out.println(browser.back());          // back to youtube
        System.out.println("Current page: " + browser.getCurrentPage());
        System.out.println(browser.forward());       // forward to github
        System.out.println("Current page: " + browser.getCurrentPage());
        browser.syncHistory();                       // additional method in AppHistory
    }
}

// Core browser history class
class BrowserHistory {
    // Internal doubly linked list node
    private class Node {
        String url;
        Node prev, next;

        Node(String url) {
            this.url = url;
        }
    }

    private Node current;

    public void visit(String url) {
        Node newNode = new Node(url);
        if (current != null) {
            current.next = newNode;
            newNode.prev = current;
        }
        current = newNode;
        current.next = null;
        System.out.println("Visited: " + url);
    }

    public String back() {
        if (current != null && current.prev != null) {
            current = current.prev;
            return "Went back to: " + current.url;
        }
        return "No previous page.";
    }

    public String forward() {
        if (current != null && current.next != null) {
            current = current.next;
            return "Went forward to: " + current.url;
        }
        return "No forward page.";
    }

    public String getCurrentPage() {
        return current != null ? current.url : "No page loaded";
    }
}

// Child class to demonstrate inheritance
class AppHistory extends BrowserHistory {
    public void syncHistory() {
        System.out.println("History synced to cloud.");
    }
}
