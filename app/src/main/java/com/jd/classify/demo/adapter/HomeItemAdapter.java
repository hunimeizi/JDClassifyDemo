package com.jd.classify.demo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.gxmall.GlideImageView;
import com.jd.classify.demo.R;
import com.jd.classify.demo.bean.CategoryBean;

import java.util.List;

public class HomeItemAdapter extends BaseAdapter {

    private Context context;
    private List<CategoryBean.DataBean.DataListBean> foodDatas;

    public HomeItemAdapter(Context context, List<CategoryBean.DataBean.DataListBean> foodDatas) {
        this.context = context;
        this.foodDatas = foodDatas;
    }


    @Override
    public int getCount() {
        if (foodDatas != null) {
            return foodDatas.size();
        } else {
            return 10;
        }
    }

    @Override
    public Object getItem(int position) {
        return foodDatas.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CategoryBean.DataBean.DataListBean subcategory = foodDatas.get(position);
        ViewHold viewHold = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_home_category, null);
            viewHold = new ViewHold();
            viewHold.tv_name = (TextView) convertView.findViewById(R.id.item_home_name);
            viewHold.iv_icon = convertView.findViewById(R.id.item_album);
            convertView.setTag(viewHold);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }
        viewHold.tv_name.setText(subcategory.getTitle());
        viewHold.iv_icon.load(subcategory.getImgURL(), R.mipmap.product_default, 10);
        convertView.setOnClickListener(view -> Toast.makeText(context, subcategory.getTitle() + position, Toast.LENGTH_SHORT).show());
        return convertView;


    }

    private static class ViewHold {
        private TextView tv_name;
        private GlideImageView iv_icon;
    }

}
