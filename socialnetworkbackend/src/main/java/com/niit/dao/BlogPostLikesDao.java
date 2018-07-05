package com.niit.dao;

import com.niit.model.BlogPost;
import com.niit.model.BlogPostLikes;

public interface BlogPostLikesDao {
	

	BlogPostLikes hasUserLikedBlogPost (int blogpostId, String email);

	//Null will be returned /1 blogpostlikes object will be returned
    //Null-glyphicon in black color
	//1-object glyphicon in blue color


	BlogPost updateBlogPostLikes(int blogPostId, String email);

	
	
	
}
