# RemoteCommentDemo
Demo Android App that posts a comment to a remote store

The app has a MainActivity thas allows the user to type a message and post it to the remote store using a Presenter object and a Comment object (Model View Presenter design pattern).

The app stores the endpoint value in the strings.xml file. This value can be changed any time and this won't affect Comment class. If the endpoint/remote store is changed a modification in the Presenter class could be needed; for example, postComment() could be changed to save the comment in shared preferences or another method could be added in the presenter class without affecting MainActivity or Comment classes.

The Presenter class has a postComment() method which receives a String parameter (the comment to be posted). If the Comment object already has the same String comment, the class returns the current Comment instance (Singleton design pattern). This way we avoid to create similar objects. Singleton design pattern was used on Volley class as well.

Further codification would be needed if we want to avoid posting comments with the same text in the remote store, in that case a isCommentAlreadySaved() method will be needed in the Presenter class and that method should be called before posting a new comment:

public boolean isCommentAlreadySaved(String commentText) {
      //Check if the comment already exists in the remote store
      return false;
}

public void postComment(String commentText) {
      if(!getComment(commentText)){
          String url = context.getString(R.string.endpoint);
          Comment comment = Comment.getInstance(commentText);
          GsonRequest request = new GsonRequest(Request.Method.POST, url, comment, null, null, this, this);
          VolleySingleton.getInstance(context).getRequestQueue().add(request);
      }
}

