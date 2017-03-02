package com.example.lofm.remotetest.presenter;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.lofm.remotetest.R;
import com.example.lofm.remotetest.model.Comment;
import com.example.lofm.remotetest.rest.GsonRequest;
import com.example.lofm.remotetest.rest.VolleySingleton;


/**
 * Created by LOFM on 02/03/2017.
 */

public class Presenter implements Response.Listener<Object>, Response.ErrorListener {

    private Context context;

    public Presenter(Context context) {
        this.context = context;
    }

    public void postComment(String commentText) {
        String url = context.getString(R.string.endpoint);
        Comment comment = Comment.getInstance(commentText);
        GsonRequest request = new GsonRequest(Request.Method.POST, url, comment, null, null, this, this);
        VolleySingleton.getInstance(context).getRequestQueue().add(request);
    }

    @Override
    public void onResponse(Object response) {
        //Do something with the response class if needed
        Toast.makeText(context, context.getString(R.string.successfulMSG), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        error.printStackTrace();
    }

}
