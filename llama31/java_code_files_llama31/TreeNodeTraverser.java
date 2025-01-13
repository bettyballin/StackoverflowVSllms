/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class TreeNodeTraverser {
    public void traverseDown(TreeNode treeNode, List<String> list) {
        list.add(treeNode.getId());
        for (TreeNode treeNode2 : treeNode.getChildren()) {
            this.traverseDown(treeNode2, list);
        }
    }

    public void traverseUp(TreeNode treeNode, List<String> list) {
        list.add(treeNode.getId());
        for (TreeNode treeNode2 : treeNode.getParents()) {
            this.traverseUp(treeNode2, list);
        }
    }

    public List<List<String>> getAllLinks(TreeNode treeNode) {
        ArrayList<List<String>> arrayList = new ArrayList<List<String>>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        this.traverseDown(treeNode, arrayList2);
        arrayList.add(new ArrayList<String>(arrayList2));
        arrayList2.clear();
        this.traverseUp(treeNode, arrayList2);
        arrayList.add(new ArrayList<String>(arrayList2));
        return arrayList;
    }

    public static void main(String[] stringArray) {
        TreeNodeTraverser treeNodeTraverser = new TreeNodeTraverser();
        TreeNode treeNode = new TreeNode("A");
        TreeNode treeNode2 = new TreeNode("B");
        TreeNode treeNode3 = new TreeNode("C");
        TreeNode treeNode4 = new TreeNode("D");
        treeNode.addChild(treeNode2);
        treeNode2.addChild(treeNode3);
        treeNode3.addChild(treeNode4);
        treeNode4.addParent(treeNode3);
        treeNode3.addParent(treeNode2);
        treeNode2.addParent(treeNode);
        List<List<String>> list = treeNodeTraverser.getAllLinks(treeNode2);
        for (List<String> list2 : list) {
            System.out.println(list2);
        }
    }
}
