package hw;

public class FinalProgram {
	static void diff(BSTNode<Integer> node)
	{
		if (node == null)
			return;
		//int d = evenCnt(node.left)- evenCnt(node.right);
		System.out.print(d + " ");
		diff(node.left);
		diff(node.right);
	}
}
