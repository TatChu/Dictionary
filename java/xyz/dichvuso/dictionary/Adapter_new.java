package xyz.dichvuso.dictionary;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tatchu on 28/04/2016.
 */
public class Adapter_new  extends BaseAdapter {
    private List<Word> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    ImageButton imgL, imgR;
    TextView txtW;
    EditText text_Search;
    ListView lsWord;
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

        imgL = (ImageButton) convertView.findViewById(R.id.imgLeft);
        imgR = (ImageButton) convertView.findViewById(R.id.imgRight);
        lsWord = (ListView) convertView.findViewById(R.id.listWord);
        txtW = (TextView) convertView.findViewById(R.id.txtWord);
        text_Search = (EditText) convertView.findViewById(R.id.txt_input);
        imgL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "You touched on Left button", Toast.LENGTH_LONG).show();
            }
        });
        imgR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "You touched on Right button", Toast.LENGTH_LONG).show();
            }
        });

        txtW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "You touched on text: " + txtW.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


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
