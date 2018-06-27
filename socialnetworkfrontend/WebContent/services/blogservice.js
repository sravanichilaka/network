/**
 * BlogServive
 */
app.factory('BlogService',function($http){
	var blogService={}
	
	
	blogService.addBlog=function(blog){
		
		return $http.post("http://localhost:8090/socialnetworkmiddleware/addblogpost",blog)
	}
		
		return blogService;	
})
	

