package com.niit.dao;

 import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.BlogPost;
import com.niit.model.BlogPostLikes;
import com.niit.model.User;
@Repository
@Transactional
public class BlogPostLikesDaoImpl implements BlogPostLikesDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public BlogPostLikes hasUserLikedBlogPost(int blogpostId, String email) {
			
	Session session=sessionFactory.getCurrentSession();
	Query query=session.createQuery("from BlogPostLikes where blogpost.id=? and user.email=?");
	query.setInteger(0,blogpostId);
	query.setString(1, email);
	BlogPostLikes blogPostLikes=(BlogPostLikes)query.uniqueResult();
	return blogPostLikes;
	
	}

	public BlogPost updateBlogPostLikes(int blogPostId, String email) {
		Session session=sessionFactory.getCurrentSession();
		BlogPostLikes blogPostLikes=hasUserLikedBlogPost(blogPostId,email);
		BlogPost blogPost=(BlogPost) session.get(BlogPost.class,blogPostId);
		
		//create a new BlogPostLikes object and set valiues for BlogPost and User
		if(blogPostLikes==null){//insert  record into blogpostlikes and increament the likes
			 blogPostLikes=new BlogPostLikes();
			 User user=(User)session.get(User.class,email);
			 blogPostLikes.setBlogpost(blogPost);
			 blogPostLikes.setUser(user);
			 session.save(blogPostLikes); //insert into blogpostlikes
			 blogPost.setLikes(blogPost.getLikes() + 1);//set likes= likes+1
			 session.update(blogPost);
			 
		}else{//delete record from the blogpostlikes and decrement the count
			session.delete(blogPostLikes);
			blogPost.setLikes(blogPost.getLikes() - 1);
			session.update(blogPost);
		
		}
		return blogPost;
		
	}
	
	

}
 