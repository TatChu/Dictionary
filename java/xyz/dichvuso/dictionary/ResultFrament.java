package xyz.dichvuso.dictionary;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by tatchu on 27/04/2016.
 */
public class ResultFrament extends Fragment {
    WebView webResult;
    public ResultFrament() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frament_result, container, false);


        webResult = (WebView)rootView.findViewById(R.id.webResult);
        webResult.getSettings().setJavaScriptEnabled(true);
        String html = "<html> <head>  </head> <body> " +
                "<span class=\"title\">color /\"kʌlə/</span><br /><span class=\"type\">danh từ & động từ</span><ul><li>(từ Mỹ,nghĩa Mỹ) (như) colour</li></ul><span class=\"title\">Chuyên ngành kỹ thuật</span><br /><ul><li>chất màu</li><li>độ đậm</li><li>nhuộm màu</li><li>màu</li><li>màu sắc</li><li>sắc màu</li><li>sắc thái</li><li>thuốc nhuộm</li></ul><span class=\"title\">Lĩnh vực: xây dựng</span><br /><ul><li>thuần túy (nguyên chất)</li></ul>" +
                " </body> </html>";
        webResult.loadData(html, "text/html; charset=utf-8", "UTF-8");

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
