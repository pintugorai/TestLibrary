package GraphUtils;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

class Query {
	static final String NODES = "Graph.nodes";
	static final String EDGES = "Graph.edges";
	static final String SIZE = ".length";
}

class Graph {
	int n;
	int e;
	HashMap<String, String> nodes = new HashMap<>();
	HashMap<String, String> edges = new HashMap<>();
}

public class GraphsUtils {

	Graph g = new Graph();
	
	private Object load(WebDriver driver, String query) {
		return ((JavascriptExecutor) driver).executeScript(query);
		
	}

	private Graph getGraph(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		g.n = (int) js.executeScript(Query.NODES + Query.SIZE);
		g.e = (int) js.executeScript(Query.EDGES + Query.SIZE);
		g.nodes = (HashMap<String, String>) js.executeScript(Query.NODES);
		g.edges = (HashMap<String, String>) js.executeScript(Query.EDGES);
		return g;
	}

	private int getNodeIndex(WebDriver driver, String targetKey, String targetValue) {
		// code
		return -1;
	}

	private int getEdgeIndex(WebDriver driver, String targetKey, String targetValue) {
		Graph graph = getGraph(driver);
		// logic for index
		return -1;
	}

	public int getNoOfNodes(WebDriver driver) {
		return getGraph(driver).n;
	}
	public int getNoOfEdges(WebDriver driver) {
		return getGraph(driver).e;
	}
	public boolean validateNodeDetails(WebDriver driver, HashMap<String, String> expectedValues) {
		//code
		return true;
	}
	
	public boolean validateEdgeDetails(WebDriver driver, HashMap<String, String> expectedValues) {
		//code
		return true;
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		WebDriver driver;
	}
}
