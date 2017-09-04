package cn.raymond.www.iBasket.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import cn.raymond.www.iBasket.R;
import cn.raymond.www.iBasket.view.fragment.BoutiqueFragment;
import cn.raymond.www.iBasket.view.fragment.CartFragment;
import cn.raymond.www.iBasket.view.fragment.CategoryFragment;
import cn.raymond.www.iBasket.view.fragment.NewGoodsFragment;
import cn.raymond.www.iBasket.view.fragment.PersonCenterFragment;

/**
 * transaction.add() 与replace() 的区别：
 * 后者相当于add() remove(), 所有销毁离开的Fragment
 *      验证：重新返回后，Fragment页面的editView输入值已经销毁
 */
public class MainActivity extends AppCompatActivity {
    private NewGoodsFragment mNewGoodsFragment;
    private BoutiqueFragment mBoutiqueFragment;
    private CategoryFragment mCategoryFragment;
    private CartFragment mCartFragment;
    private PersonCenterFragment mPersonCenterFragment;
    private Fragment[] fragments;

    private int index = 0; // 目标Fragment的索引值
    private int currentIndex = 0;// 当前Fragment的索引值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, mNewGoodsFragment)
                .add(R.id.fragment_container, mBoutiqueFragment)
                .add(R.id.fragment_container, mCategoryFragment)
                .add(R.id.fragment_container, mCartFragment)
                .add(R.id.fragment_container, mPersonCenterFragment)
                .hide(mBoutiqueFragment)//必须隐藏，否则Fragment重叠
                .hide(mCategoryFragment)
                .hide(mCartFragment)
                .hide(mPersonCenterFragment)
                .show(mNewGoodsFragment)
                .commit();

    }

    private void initFragment() {
        fragments = new Fragment[5];
        mNewGoodsFragment = new NewGoodsFragment();
        mBoutiqueFragment = new BoutiqueFragment();
        mCategoryFragment = new CategoryFragment();
        mCartFragment     = new CartFragment();
        mPersonCenterFragment = new PersonCenterFragment();

        fragments[0] = mNewGoodsFragment;
        fragments[1] = mBoutiqueFragment;
        fragments[2] = mCategoryFragment;
        fragments[3] = mCartFragment;
        fragments[4] = mPersonCenterFragment;
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_new_goods:
                index = 0;
                break;
            case R.id.btn_boutique:
                index = 1;
                break;
            case R.id.btn_category:
                index = 2;
                break;
            case R.id.btn_cart:
                index = 3;
                break;
            case R.id.btn_personal_center:
                index = 4;
                break;
        }
        setFragment();
    }

    private void setFragment() {
        if (index != currentIndex) { // 切换Fragment的条件
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(fragments[currentIndex]); // 隐藏当前Fragment
            if (!fragments[index].isAdded()) { // 若目标Fragment没有实例化到退回栈，add()
                transaction.add(R.id.fragment_container, fragments[index]);
            }
            transaction.show(fragments[index]).commit(); // 显示目标Fragment
            currentIndex = index; // 这一步是必须的，修改当前页的索引值
        }
    }
}
