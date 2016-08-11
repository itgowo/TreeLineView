package com.freemind.lujianchao.freemindtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Tree mTree;
    private List<TreeBean> mTrees = new ArrayList<>();

    @Override
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

    public void test(View mView) {
    }
}
