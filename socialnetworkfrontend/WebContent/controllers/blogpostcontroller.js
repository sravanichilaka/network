/**
 * BlogCtrl
 */
app.controller('BlogCtrl',function($scope,BlogService,$location,$rootScope){
	
	$scope.addBlog=function(blog){
		BlogService.addBlog(blog).then(function(response){
			
			alert('Blogpost has been inserted successfully..... It is waitting for approvial')
			$location.path('/home')
			
		},function(response){
			
			$scope.error==response.data
			if(response.status==401)
			$location.path('/login')		
		
		
	})
	
}

})