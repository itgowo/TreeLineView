# TreeLineView 
### 一:介绍
前同事要做家庭关系图，并且要纯原生开发，于是我用代码简单绘制了一个demo，希望大家提提意见共同进步。

主要使用view的ondraw方法用画笔绘制界面，并且根据触摸位置判断点击哪个元素，按理说逻辑还应该复杂点，但是为了简单，我好些逻辑没写完，有时间我再补充上。

qq:1264957104

### 二:例子

![](https://github.com/hnsugar/TreeLineView/blob/master/222.png)
![](https://github.com/hnsugar/TreeLineView/blob/master/111.jpg)

### 三:使用方法

      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            TreeBean m1 = new TreeBean("1", 0, 0, 1, null, "ssss", "张三丰1", "中国人1", "1630年", " 155");
            TreeBean m2 = new TreeBean("2", 0, 1, 3, "1", "ssss", "张三丰2", "中国人2", "1630年", " 155");
            TreeBean m3 = new TreeBean("3", 1, 1, 3, "1", "ssss", "张三丰3", "中国人3", "1630年", " 155");
            TreeBean m4 = new TreeBean("4", 2, 1, 3, "1", "ssss", "张三丰4", "中国人4", "1630年", " 155");
            mTrees.add(m1);
            mTrees.add(m2);
            mTrees.add(m3);
            mTrees.add(m4);
    
            mTree = (Tree) findViewById(R.id.tree);
            mTree.setOnTreeViewClickListener(new Tree.OnTreeViewClickListener() {
                @Override
                public void onClickListener(TreeBean mTreeBean) {
                    System.out.println("onClickListener mTreeBean = [" + mTreeBean + "]");
                }
    
                @Override
                public void onLongClickListener(TreeBean mTreeBean) {
                    System.out.println("onLongClickListener mTreeBean = [" + mTreeBean + "]");
                }
            });
            mTree.setTrees(mTrees);
        }
