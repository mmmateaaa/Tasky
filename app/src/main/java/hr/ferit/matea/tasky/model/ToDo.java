package hr.ferit.matea.tasky.model;

import android.util.EventLogTags;

import javax.crypto.spec.DESKeySpec;

/**
 * Created by Matea on 4/18/2018.
 */

public class ToDo {
    private int mId;
    private String mTitle;
    private String mDescription;
    private String mImgUrl;

    public ToDo(int id, String title, String description, String imgUrl) {
        mId = id;
        mTitle = title;
        mDescription = description;
        mImgUrl = imgUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setmTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getImgUrl() {

        return mImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        mImgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "mTitle='" + mTitle + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mImgUrl='" + mImgUrl + '\'' +
                '}';
    }

    public int getId() {
        return mId;
    }
}
