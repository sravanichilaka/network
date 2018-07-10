/**
 * Job Service
 */
app.factory('JobService',function($http){

	var jobService={}
	
	jobService.addJob=function(job){
		return $http.post("http://localhost:8055/socialnetworkmiddleware/addjob",job)
	}
	
	jobService.getActiveJobs=function(job){
		return $http.get("http://localhost:8055/socialnetworkmiddleware/activejobs")
	}
	
	jobService.getInActiveJobs=function(job){
		return $http.get("http://localhost:8055/socialnetworkmiddleware/inactivejobs")
	}
	
	jobService.updateActiveStatus=function(job){
		return $http.put("http://localhost:8055/socialnetworkmiddleware/updatejob",job)
	}
	return jobService;
	
})