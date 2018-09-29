class Node {
	// data class
	int id;
    int x = 0;
    int y = 0;
    double distance = 0.0;

    Node(int id, int x, int y) {
    	this.id = id;
        this.x = x;
        this.y = y;
    }

    double getDistance(Node target) { // distance from target to node
        return Math.sqrt(Math.pow(target.x - x, 2) + (Math.pow(target.y - y, 2)));
    }

}