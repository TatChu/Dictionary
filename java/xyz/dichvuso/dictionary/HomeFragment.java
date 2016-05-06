package xyz.dichvuso.dictionary;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.Image;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * Created by tatchu on 26/04/2016.
 */

public class HomeFragment extends Fragment {
    final  int REQ_CODE_SPEECH_INPUT = 100;
    public static final int RESULT_OK          = -1;
    TextView txt_input;
    ImageView img_record, img_clear;
    ListView listWord;
    ImageButton btn_focus;
    TextView txt_word;
    SQLiteDatabase db;
    Adapter_new adapter= null;
    List<Word> danhsach,list;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        txt_input = (TextView) rootView.findViewById(R.id.txt_input);
        img_clear = (ImageView) rootView.findViewById(R.id.img_clear);
        img_record = (ImageView) rootView.findViewById(R.id.img_record);
        listWord = (ListView) rootView.findViewById(R.id.listWord);

        img_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_input.setText("");
                img_clear.setBackground(null);
            }
        });
        img_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), txt_input.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });


        txt_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                img_clear.setBackgroundResource(R.drawable.clear);
                listWord.setBackgroundResource(R.color.colorPrimaryDark);
                listWord.setVisibility(View.VISIBLE);

                danhsach = new ArrayList<Word>();
                list = new ArrayList<Word>();
                String word = txt_input.getText().toString().toLowerCase() + "%";

                String empty = "";
                /*
                if (!txt_input.getText().toString().equals(empty))
                {
                    danhsach = db.getListWord("Select * from words_0061 where word like  '" + word + "' and lang = 'en'");
                    for (int i = 0; i<= danhsach.size(); i++)
                        list.add(danhsach.get(i));

                    adapter  = new Adapter_new(getActivity(), R.layout.listview_word, list);
                    listWord.setAdapter(adapter);
                }
                else
                    adapter = null;
                listWord.setAdapter(adapter);
                */
                if (!txt_input.getText().toString().equals(empty)) {
                    list.add(new Word("color", "mau sac", "en"));
                    list.add(new Word("boss", "ong chu", "en"));
                    list.add(new Word("action", "hanh dong", "en"));
                    list.add(new Word("big boss", "mau sac", "en"));
                    list.add(new Word("the boss", "ong chu", "en"));
                    list.add(new Word("website", "hanh dong", "en"));
                    list.add(new Word("theme", "mau sac", "en"));
                    list.add(new Word("computer", "ong chu", "en"));
                    list.add(new Word("kyeboard", "hanh dong", "en"));
                    list.add(new Word("bag", "mau sac", "en"));
                    list.add(new Word("plus", "ong chu", "en"));
                    list.add(new Word("line", "hanh dong", "en"));
                    list.add(new Word("mouse", "mau sac", "en"));
                    list.add(new Word("adapter", "ong chu", "en"));
                    list.add(new Word("window", "hanh dong", "en"));
                    list.add(new Word("key", "mau sac", "en"));
                    list.add(new Word("air", "ong chu", "en"));
                    list.add(new Word("monitor", "hanh dong", "en"));
                    list.add(new Word("table", "mau sac", "en"));
                    list.add(new Word("chair", "ong chu", "en"));
                    list.add(new Word("shoe", "hanh dong", "en"));
                    list.add(new Word("cable", "mau sac", "en"));
                    list.add(new Word("contract", "ong chu", "en"));
                    list.add(new Word("circle", "hanh dong", "en"));

                    adapter = new Adapter_new(getActivity(), R.layout.listview_word, list);
                    listWord.setAdapter(adapter);

                } else {
                    img_clear.setBackgroundResource(R.color.windowBackground);
                    adapter = null;
                    listWord.setAdapter(adapter);
                    listWord.setBackgroundResource(R.color.windowBackground);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        img_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });


        listWord.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, final long id) {
                btn_focus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "You touched right button on list with id = " + String.valueOf(id) , Toast.LENGTH_SHORT).show();
                    }
                });/*
                Fragment fragment = null;
                String title = getString(R.string.app_name);
                fragment = new ResultFrament();
                title = getString(R.string.title_test);

                Toast.makeText(getActivity(), "You touched on " + String.valueOf(position) + " on list!", Toast.LENGTH_SHORT).show();
                try {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_body, fragment);
                    fragmentTransaction.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                */
            }

        });

        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if ((resultCode == RESULT_OK) && (null != data)) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txt_input.setText(result.get(0));
                }
                break;
            }

        }
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, R.string.speak);
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getContext(), R.string.no_suport, Toast.LENGTH_SHORT).show();
        }
    }

}
