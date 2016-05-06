package xyz.dichvuso.dictionary;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tatchu on 28/04/2016.
 */
public class Adapter_new  extends BaseAdapter {
    private List<Word> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter_new(Context aContext, int listview_word, List<Word> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.listview_word, null);
            holder = new ViewHolder();
            holder.img_right = (ImageButton) convertView.findViewById(R.id.imgRight);
            holder.img_left = (ImageButton) convertView.findViewById(R.id.imgLeft);
            holder.txt_word = (TextView) convertView.findViewById(R.id.txtWord);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Word word = this.listData.get(position);
        holder.txt_word.setText(word.getWord());

        return convertView;
    }

    // Tìm ID của Image ứng với tên của ảnh (Trong thư mục mipmap).
    public int getMipmapResIdByName(String resName) {
        String pkgName = context.getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = context.getResources().getIdentifier(resName, "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

    static class ViewHolder {
        ImageButton img_left;
        ImageButton img_right;
        TextView txt_word;
    }

}
