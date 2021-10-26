package com.example.miwok;

public class Word {

    private String name;
    private String miw_name;
    private int image_id;
    private int audioId;
    private int isImageAdded = 0;

    public Word(String num, String miw, int audio) {
        name = num;
        miw_name = miw;
        audioId = audio;
    }

    public Word(String num, String miw, int id, int audio) {
        name = num;
        miw_name = miw;
        image_id = id;
        isImageAdded = 1;
        audioId = audio;
    }

    public boolean hasImage() {
        if (isImageAdded == 1)
            return true;
        return false;
    }

    public int getImage_id() {
        return image_id;
    }

    public String getName() {
        return name;
    }

    public int getAudioId() {
        return audioId;
    }

    public String getMiw_name() {
        return miw_name;
    }
}
