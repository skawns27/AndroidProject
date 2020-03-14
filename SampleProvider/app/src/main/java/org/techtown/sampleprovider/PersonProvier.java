package org.techtown.sampleprovider;

import android.content.ContentProvider;
import android.net.Uri;

public class PersonProvier extends ContentProvider {
    public static final String AUTHORITY="org.techdown.provider";
    public static final String BASE_PATH="person";
    public static final Uri CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/"+BASE_PATH);

    private static final int PERSONS=1;
    public static final int PERSON_ID=2;
}
