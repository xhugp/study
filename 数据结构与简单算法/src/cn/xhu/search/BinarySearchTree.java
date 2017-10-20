package cn.xhu.search;

public class BinarySearchTree {
	//���ڵ�
	private TreeNode root = null;
	/**
	 * �ڲ������ڴ������Ľڵ�
	 * @author Administrator
	 *
	 */
	class TreeNode{
		int value;
		int position;
		TreeNode left = null;
		TreeNode right = null;
		TreeNode(int value,int position){
			this.value = value;
			this.position = position;
		}		
	}
	//�������
	public void add(int value,int position){
		if(root==null){
			root = new TreeNode(value,position);
		}
		else{
			add(value,position,root);	
		}
	}
	//�������
	private void add(int value, int position, TreeNode node) {
		// TODO Auto-generated method stub
		if(node==null){
			System.out.println("�ڵ㲻��Ϊ��");
		}
		if(node.value == value){
			return;
		}
		if(node.value>value){
			if(node.left!=null){
				add(value,position,node.left);
			}else{
				node.left = new TreeNode(value,position);
			}
		}else if(node.value<value){
			if(node.right!=null){
				add(value,position,node.right);
			}else{
				node.right = new TreeNode(value,position);
			}
		}
	}
	
	public int search(int value){
		return search(value,root);
	}
	

	private int search(int value, TreeNode node) {
		// TODO Auto-generated method stub
		if(node.value == value){
			return node.position;
		}else if(value>node.value){
			if(node.right!=null){
				return search(value,node.right);
			}
		}else if(value<node.value){
			if(node.left!=null){
				return search(value,node.left);
			}
		}				
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree tree = new BinarySearchTree();
		int[] arr = {5,4,6,2,3,7,9};
		for(int i=0;i<arr.length;i++){
			tree.add(arr[i], i);
		}
//		System.out.println(tree.root.right.value);
		System.out.println(tree.search(5));
		System.out.println(tree.search(3));
		System.out.println(tree.search(9));
		System.out.println(tree.search(8));
	}

}
