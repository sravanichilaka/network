/**
 * BlogService
 */
app.factory('BlogService',function($http){
	var blogService={}
	blogService.addBlog=function(blog){
		return $http.post("http://localhost:8090/socialnetworkmiddleware/addblogpost",blog)
		
	}
	blogService.blogsApproved=function(){
		return $http.get("http://localhost:8090/socialnetworkmiddleware/blogsapproved")
		
	}
	blogService.blogsWaitingForApproval=function(){
		return $http.get("http://localhost:8090/socialnetworkmiddleware/blogswaitingforapproval")
		
	}
	blogService.getBlogPost=function(id){
		return $http.get("http://localhost:8090/socialnetworkmiddleware/getblogpost/"+id)
	}
	blogService.updateApprovalStatus=function(blogPost){
		return $http.put("http://localhost:8090/socialnetworkmiddleware/updatestatusapproval",blogPost)
		
		//if admin approves the blogpost,blogPost.approve
		//if admin reject the blogpost,blogPost.reject
	}
	
	blogService.hasUserLikedBlog=function(blogpostId){
		return $http.get("http://localhost:8090/socialnetworkmiddleware/hasuserlikedblog/"+blogpostId)
	}
	blogService.updateBlogPostLikes=function(blogpostId){
		return $http.put("http://localhost:8090/socialnetworkmiddleware/updateblogpostlikes/"+blogpostId)

		//blogPost id and commentTxt
		//id is the id of the blogPost
		//commentTxt=Good,Thanks,well Explained
		//id=54
		//http://............//addcomment/Good,Thanks,well Explained
	}
	blogService.addComment=function(commentTxt,id){
		return $http.post("http://localhost:8090/socialnetworkmiddleware/addcomment/"+commentTxt+"/"+id)
		
	}
	blogService.getAllBlogComments=function(blogPostId){
		return $http.get("http://localhost:8090/socialnetworkmiddleware/getblogcomments/"+blogPostId);
	}
		
	return blogService;
}) 