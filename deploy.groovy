node('linux'){
enviroment{
	credentialsID = 'michalnagosa2'
}
stage('git'){
	git branch: 'master',
	   url:'https://github.com/michalnagosa2/flask-http.git'
}
}
