package xyz.dichvuso.dictionary;

/**
 * Created by tatchu on 28/04/2016.
 */
public class Word {
    private int id;
    private String word;
    private String content;
    private String lang;

    public void setId(int id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }


    public String getLang() {
        return lang;
    }

    public String getContent() {
        return content;
    }

    public String getWord() {
        return word;
    }

    public int getId() {
        return id;
    }



    public Word(){}
    public Word(String word, String content, String lang)
    {
        this.word = word; this.content = content; this.lang = lang;
    }

}
