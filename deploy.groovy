node('linux'){
enviroment{
	credentialsID = 'jenkins'
}
stage('git'){
	git branch: 'master',
	   url:'https://github.com/michalnagosa2/flask-http.git'
}
}
